/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Product.Product;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewPurchaseHistoryController implements Initializable {

    @FXML private ListView<String> purchaseHistoryListView; // Holds user's purchase history details

    // Shows logged-in user's purchase history
    @FXML private void showPurchaseHistoryButton() {
        try {
            if (!isValid()) {
                return;
            }
            // Assign the logged-in user's purchase history to be displayed
            final ObservableList<String> PURCHASE_HISTORY = DataHandler.loggedInUser.getProductNamesInPurchaseHistory();
            purchaseHistoryListView.setItems(PURCHASE_HISTORY);
        } catch (Exception e) {
            Utils.Text.showError("Error while showing purchase history:\n " + e.getMessage());
        }
    }

    // Validation checks
    private boolean isValid() {
        final boolean NOT_LOGGED_IN = DataHandler.loggedInUser == null;
        if (NOT_LOGGED_IN) {
            Utils.Text.showError("Can't perform action, user is not logged in.");
            return false;
        }

        final boolean CART_IS_EMPTY = DataHandler.loggedInUser.getPurchaseHistory().isEmpty();
        if (CART_IS_EMPTY) {
            Utils.Text.showError("Can't perform action, no purchase history");
            return false;
        }
        return true;
    }

    @FXML
    private void switchToMainMenu() throws Exception {
        App.setRoot("mainMenu");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
