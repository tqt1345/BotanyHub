/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import Product.*;
import User.*;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewCartController implements Initializable {

    @FXML private ListView<String> productsInCart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML private void showCartButton() {
        try {
            if (!isValid()) {
                return;
            }
            ObservableList<String> products = FXCollections.observableArrayList();
            final ArrayList<Product> USER_CART = DataHandler.currentUser.getCart();
            for (Product product : USER_CART) {
                products.add(product.getName());
            }
            productsInCart.setItems(products);
        } catch (Exception e) {
            Utils.Text.showError("Error while showing cart: " + e.getMessage());
        }
    }

    @FXML private void removeProductButton() {
        try {
            if (!isValid()) {
                return;
            }
            String selectedProduct = productsInCart.getSelectionModel().getSelectedItem();
            Product product = ProductUtils.getProduct(selectedProduct, DataHandler.currentUser.getCart());
            DataHandler.currentUser.getCart().remove(product);
            productsInCart.getItems().remove(selectedProduct);
            Utils.Text.showConfirmation("Successfully removed product from cart");
        } catch (Exception e) {
            Utils.Text.showError("Error while removing product from cart: " + e.getMessage());
        }
    }

    @FXML private void viewProductButton() {
        try {
            if (!isValid()) {
                return;
            }
            String selectedProduct = productsInCart.getSelectionModel().getSelectedItem();
            Product product = ProductUtils.getProduct(selectedProduct, DataHandler.currentUser.getCart());
            ViewIndividualProductController.currentProductName = product.getName();
            App.setRoot("viewIndividualProduct");
        } catch (Exception e) {
            Utils.Text.showError("Error while viewing product: " + e.getMessage());
        }
    }

    private boolean isValid() {
        final boolean NOT_LOGGED_IN = DataHandler.currentUser == null;
        final boolean CART_IS_EMPTY = DataHandler.currentUser.getCart().isEmpty();

        if (NOT_LOGGED_IN) {
            Utils.Text.showError("Can't perform action, user is not logged in.");
            return false;
        }

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
}
