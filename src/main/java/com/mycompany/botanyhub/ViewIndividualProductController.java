
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.Customer;
import com.mycompany.botanyhub.Product.Product;
import com.mycompany.botanyhub.Product.ProductUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewIndividualProductController implements Initializable {

    @FXML private TextArea productDetailsTextArea;  // Displays product details
    public static String currentProductName;        // Holds name of current product
    private static String previousPage;             // Holds the previous page FXML

    private Product currentProduct;

    // Sets current product
    private void setProduct(String name) {
        try {
            currentProduct = ProductUtils.getProduct(name, DataHandler.products);
            assert currentProduct != null;
            productDetailsTextArea.setText(currentProduct.toString());

        } catch (Exception e) {
            Utils.Text.showError("Error fetching product details: " + e.getMessage());
        }
    }

    // Adds current product to logged-in user's cart
    @FXML private void addToCart() {
        Customer customer;

        // Validation checks
        final boolean NOT_LOGGED_IN = DataHandler.loggedInUser == null;
        if (NOT_LOGGED_IN) {
            // TODO throw an exception instead of showing an error
            Utils.Text.showError("Can't add to cart, must be logged in.");
            return;
        }

        final boolean NOT_CUSTOMER = !(DataHandler.loggedInUser instanceof Customer);
        if (NOT_CUSTOMER) {
            Utils.Text.showError("Can't add to cart, must be a customer.");
            return;
        }

        // Add selected product to cart
        customer = (Customer) DataHandler.loggedInUser;
        customer.addProductToCart(currentProduct);
        Utils.Text.showConfirmation("Successfully added product to cart");
    }


    public static void setPreviousPage(String page) {
        previousPage = page;
    }
    // TODO should go back to previous page not hardcoded to viewProducts
    @FXML private void backButton() throws IOException {
        App.setRoot(previousPage);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setProduct(currentProductName);

    }
}
