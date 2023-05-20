/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import Product.*;
import User.*;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewCartController implements Initializable {

    @FXML private ListView<String> productsInCartListView; // Holds product details

    // Shows products in logged-in user's cart
    @FXML private void showCartButton() {
        try {
            Customer customer;
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }

            customer = (Customer) DataHandler.loggedInUser;
            ObservableList<String> products = FXCollections.observableArrayList();
            final ArrayList<Product> CUSTOMER_CART = customer.getCart();
            for (Product product : CUSTOMER_CART) {
                products.add(product.getName());
            }
            productsInCartListView.setItems(products);
        } catch (Exception e) {
            Utils.Text.showError("Error while showing cart:\n " + e.getMessage());
        }
    }

    // Removes a product from logged-in user's cart
    @FXML private void removeProductButton() {
        try {
            Customer customer;
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            customer = (Customer) DataHandler.loggedInUser;
            // TODO refactor this
            String selectedProduct = productsInCartListView.getSelectionModel().getSelectedItem();
            Product product = ProductUtils.getProduct(selectedProduct, customer.getCart());
            customer.getCart().remove(product);
            productsInCartListView.getItems().remove(selectedProduct);
            Utils.Text.showConfirmation("Successfully removed product from cart");
        } catch (Exception e) {
            Utils.Text.showError("Error while removing product from cart:\n " + e.getMessage());
        }
    }

    // Takes user to the individual product page
    @FXML private void viewProductButton() {
        try {
            Customer customer;
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            customer = (Customer) DataHandler.loggedInUser;
            final boolean NO_PRODUCT_SELECTED = productsInCartListView.getSelectionModel().getSelectedItem() == null;
            if (NO_PRODUCT_SELECTED) {
                Utils.Text.showError("Please select a product to view");
                return;
            }

            // TODO refactor this
            String selectedProduct = productsInCartListView.getSelectionModel().getSelectedItem(); // get product listing from listview
            Product product = ProductUtils.getProduct(selectedProduct, customer.getCart()); // get product object from listing
            ViewIndividualProductController.currentProductName = product.getName();
            App.setRoot("viewIndividualProduct");
        } catch (Exception e) {
            Utils.Text.showError("Error while viewing product:\n " + e.getMessage());
        }
    }

    // Makes a purchase, moving products in cart to purchase history.
    @FXML private void makePurchaseButton () {
        try {
            Customer customer;
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            customer = (Customer) DataHandler.loggedInUser;
            customer.makePurchase();
            productsInCartListView.getItems().clear();
            Utils.Text.showConfirmation("Successfully made purchase");
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
    @FXML
    private void switchToMainMenu() throws Exception {
        App.setRoot("mainMenu");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
