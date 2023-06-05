/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls functionality for viewing individual product information.
 */

package com.mycompany.botanyhub;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.Customer;
import com.mycompany.botanyhub.Product.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewIndividualProductController implements Initializable {

    // Page navigation variables
    private static Product currentProduct;
    private static String previousPage;

    // Information fields
    @FXML private TextField productNameField;
    @FXML private TextField productPriceField;
    @FXML private TextArea productDescriptionArea;

    // Sets the current product to be viewed
    public static void setCurrentProduct(Product product) {
        currentProduct = product;
    }

    // Displays the product details
    private void setProductDetails(Product product) {
        try {
            productNameField.setText(product.getName());
            productPriceField.setText("$" + product.getPrice());
            productDescriptionArea.setText(product.getDescription());
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
    @FXML private void backButton() throws IOException {
        App.setRoot(previousPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setProductDetails(currentProduct);
    }
}
