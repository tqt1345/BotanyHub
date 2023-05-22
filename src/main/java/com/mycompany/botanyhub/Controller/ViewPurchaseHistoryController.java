/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.App;
import com.mycompany.botanyhub.DataHandler;
import com.mycompany.botanyhub.User.Customer;
import com.mycompany.botanyhub.User.User;
import com.mycompany.botanyhub.Utils;
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

    private static String previousPage;
    // Shows logged-in user's purchase history
    @FXML private void showPurchaseHistoryButton() {
        try {
            Customer customer;
            if (!isValid(DataHandler.loggedInUser)) {
                return;
            }
            customer = (Customer) DataHandler.loggedInUser;
            // Assign the logged-in user's purchase history to be displayed
            final ObservableList<String> PURCHASE_HISTORY = customer.getProductNamesInPurchaseHistory();
            purchaseHistoryListView.setItems(PURCHASE_HISTORY);
        } catch (Exception e) {
            Utils.Text.showError("Error while showing purchase history:\n " + e.getMessage());
        }
    }

    // Validation checks
    private boolean isValid(User loggedInUser) {
        Customer customer;
        final boolean NOT_LOGGED_IN = loggedInUser == null;
        if (NOT_LOGGED_IN) {
            Utils.Text.showError("Can't perform action, user is not logged in.");
            return false;
        }
        final boolean NOT_CUSTOMER = !(loggedInUser instanceof Customer);
        if (NOT_CUSTOMER) {
            Utils.Text.showError("Can't perform action, user is not a customer.");
            return false;
        }
        customer = (Customer) loggedInUser;
        final boolean CART_IS_EMPTY = customer.getPurchaseHistory().isEmpty();
        if (CART_IS_EMPTY) {
            Utils.Text.showError("Can't perform action, no purchase history");
            return false;
        }
        return true;
    }

    public static void setPreviousPage(String page) {
        previousPage = page;
    }
    @FXML
    private void switchToMainMenu() throws Exception {
        App.setRoot(previousPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
