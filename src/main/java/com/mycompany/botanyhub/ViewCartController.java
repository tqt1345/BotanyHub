
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.mycompany.botanyhub.Product.Product;
import com.mycompany.botanyhub.Product.ProductUtils;
import com.mycompany.botanyhub.User.Customer;
import com.mycompany.botanyhub.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewCartController implements Initializable {

    @FXML private ListView<String> productsInCartListView;  // Holds product details
    private static String previousPage;                     // Holds the previous page FXML
    @FXML private TextField totalCostField;                 // Holds the total cost of products in cart

    // Shows products in logged-in user's cart
    @FXML private void showCartButton() {
        try {
            if (!isValidUserStatus(DataHandler.loggedInUser)) {
                return;
            }

            Customer customer = (Customer) DataHandler.loggedInUser;
            ObservableList<String> cartDetails;

            cartDetails = customer.getCart()
                        .stream()
                        .map(product -> product.getName() + ", $" + product.getPrice())
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));

            productsInCartListView.setItems(cartDetails);
            totalCostField.setText("$" + customer.getTotalCostOfCart());

        } catch(Exception e) {
            Utils.Text.showError("Error getting cart details: " + e.getMessage());
        }
    }

    // Removes a product from logged-in user's cart
    @FXML private void removeProductButton() {
        try {
            if (!isValidUserStatus(DataHandler.loggedInUser)) {
                return;
            }
            final boolean NO_PRODUCT_SELECTED = productsInCartListView.getSelectionModel().isEmpty();
            if (NO_PRODUCT_SELECTED) {
                Utils.Text.showError("Please select a product to remove");
                return;
            }
            Customer customer = (Customer) DataHandler.loggedInUser;
            final Product SELECTED_PRODUCT = getSelectedProduct();
            final int SELECTED_LISTVIEW_INDEX = productsInCartListView.getSelectionModel().getSelectedIndex();

            Utils.Text.runIfConfirmedByUser(
                    "Remove product confirmation",
                    "Are you sure you want to remove this product from your cart?\n",
                    "Press Ok to proceed",
                    () -> {
                        customer.removeProductFromCart(SELECTED_PRODUCT);
                        productsInCartListView.getItems().remove(SELECTED_LISTVIEW_INDEX);
                        totalCostField.setText("$" + customer.getTotalCostOfCart());
                        Utils.Text.showConfirmation(String.format("Successfully removed %s from cart", SELECTED_PRODUCT.getName()));

                    });
        } catch (Exception e) {
            Utils.Text.showError("Error while removing product from cart:\n " + e.getMessage());
        }
    }

    // TODO fix bug where selected product is null.
    // Takes user to the individual product page
    @FXML private void viewProductButton() throws Exception {
        if (!isValidUserStatus(DataHandler.loggedInUser)) {
            return;
        }
        final boolean NO_PRODUCT_SELECTED = productsInCartListView.getSelectionModel().isEmpty();
        if (NO_PRODUCT_SELECTED) {
            Utils.Text.showError("Please select a product to view");
            return;
        }
        final Product SELECTED_PRODUCT = getSelectedProduct();
        ViewIndividualProductController.setCurrentProduct(SELECTED_PRODUCT);
        ViewIndividualProductController.setPreviousPage("viewCart");
        App.setRoot("viewIndividualProduct");
    }

    // Makes a purchase, moving products in cart to purchase history.
    @FXML private void makePurchaseButton () {
        try {
            if (!isValidUserStatus(DataHandler.loggedInUser)) {
                return;
            }

            final boolean NO_CART_ITEMS = productsInCartListView.getItems().isEmpty();
            if(NO_CART_ITEMS) {
                Utils.Text.showError("Please view cart before making a purchase");
                return;
            }
            Customer customer;
            customer = (Customer) DataHandler.loggedInUser;

            Utils.Text.runIfConfirmedByUser(
                    "Purchase confirmation",
                    "Are you sure you want to make this purchase?\n" +
                            "This will purchase all items in your cart\n" +
                            "Total cost of purchase: $" + customer.getTotalCostOfCart() + "\n",
                    "Press Ok to proceed",
                    () -> {
                        customer.makePurchase();
                        productsInCartListView.getItems().clear();
                        Utils.Text.showConfirmation("Successfully made purchase");
                    });
        } catch (Exception e) {
            Utils.Text.showError("Error while making purchase:\n " + e.getMessage());
        }
    }

    /* Validation checks:
    - User is logged in?
    - User is a customer?
    - Cart is empty?
     */
    private boolean isValidUserStatus(User loggedInUser) {
        Customer customer;

        final boolean NOT_LOGGED_IN = loggedInUser == null;
        if (NOT_LOGGED_IN) {
            Utils.Text.showError("Can't perform action, user is not logged in.");
            return false;
        }

        final boolean IS_CUSTOMER = loggedInUser instanceof Customer;
        if (IS_CUSTOMER) {
            customer = (Customer) loggedInUser;
        } else {
            Utils.Text.showError("Can't perform action, user is not a customer.");
            return false;
        }

        final boolean CART_IS_EMPTY = customer.getCart().isEmpty();
        if (CART_IS_EMPTY) {
            Utils.Text.showError("Can't perform action, cart is empty.");
            return false;
        }
        return true;
    }

    private Product getSelectedProduct() throws Exception {
        return ProductUtils.getProductFromName(
                productsInCartListView.getSelectionModel()
                        .getSelectedItem()
                        .split(",")[0],
                DataHandler.products);
    }

    public static void setPreviousPage(String page) {
        previousPage = page;
    }

    @FXML
    private void backButton() throws Exception {
        App.setRoot(previousPage);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
