
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            Customer customer = (Customer) DataHandler.loggedInUser;
            ObservableList<String> products = FXCollections.observableArrayList();
            final ArrayList<Product> CUSTOMER_CART = customer.getCart();

            for (Product product : CUSTOMER_CART) {
                products.add(product.getName() + ", $" + product.getPrice());
            }
            productsInCartListView.setItems(products);
            totalCostField.setText("$" + customer.getTotalCostOfCart());

        } catch (Exception e) {
            Utils.Text.showError("Error while showing cart:\n " + e.getMessage());
        }
    }

    // Removes a product from logged-in user's cart
    @FXML private void removeProductButton() {
        try {
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            Customer customer = (Customer) DataHandler.loggedInUser;
            final Product SELECTED_PRODUCT = ProductUtils.getProduct(
                    productsInCartListView.
                            getSelectionModel().
                            getSelectedItem(),
                    DataHandler.products);
            assert SELECTED_PRODUCT != null;
            final String SELECTED_PRODUCT_NAME = SELECTED_PRODUCT.getName();

            customer.removeProductFromCart(SELECTED_PRODUCT);
            removeFromListView(SELECTED_PRODUCT_NAME);
            Utils.Text.showConfirmation("Successfully removed product from cart");
        } catch (Exception e) {
            Utils.Text.showError("Error while removing product from cart:\n " + e.getMessage());
        }
    }

    // TODO fix bug where selected product is null.
    // Takes user to the individual product page
    @FXML private void viewProductButton() {
        try {
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            final boolean NO_PRODUCT_SELECTED = productsInCartListView.getSelectionModel().getSelectedItem() == null;
            if (NO_PRODUCT_SELECTED) {
                Utils.Text.showError("Please select a product to view");
                return;
            }

            // TODO Bug: selected product is null: product name passed into getProduct() includes the price (it should just be the name)
            final Product SELECTED_PRODUCT = ProductUtils.getProduct(
                    productsInCartListView.
                            getSelectionModel().
                            getSelectedItem(),
                    DataHandler.products);

            assert SELECTED_PRODUCT != null;
            ViewIndividualProductController.setCurrentProduct(SELECTED_PRODUCT);
            ViewIndividualProductController.setPreviousPage("viewCart");
            App.setRoot("viewIndividualProduct");
        } catch (Exception e) {
            Utils.Text.showError("Error while viewing product:\n " + e.getMessage());
        }
    }

    // Makes a purchase, moving products in cart to purchase history.
    @FXML private void makePurchaseButton () {
        try {
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            Customer customer;
            customer = (Customer) DataHandler.loggedInUser;

            Utils.Text.runIfConfirmedByUser(
                    "Purchase confirmation",
                    "Are you sure you want to make this purchase?\n" +
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
    private boolean isValid(User loggedInUser) {
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

    private void removeFromListView(String productName) {
        productsInCartListView.getItems().remove(productName);
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
