/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import User.*;
import Product.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class MainMenuController implements Initializable {
    @FXML private Label currentUserLabel; // Displays username of logged-in user

    @FXML private void switchToCreateAccount() throws IOException {
        App.setRoot("createAccount");
        App.previousScene = "mainMenu";
    }

    @FXML private void switchToLogin() throws IOException {
        App.setRoot("login");
        App.previousScene = "mainMenu";
    }

    @FXML private void logoutButton() throws Exception {
        final boolean USER_LOGGED_IN = DataHandler.loggedInUser != null;
        if (USER_LOGGED_IN) {
            UserUtils.logout();
            Utils.Text.showConfirmation("Logout successful");
        } else {
            throw new Exception("Can't perform action:\n No user is currently logged in");
        }
    }

    @FXML private void switchToViewProducts() throws IOException {
        try {
            App.setRoot("viewProducts");

        } catch (Exception e) {
            Utils.Text.showError(e.getMessage());
        }
    }
    @FXML private void switchToViewCart() throws IOException {
        App.setRoot("viewCart");
    }
    @FXML private void switchToViewPurchaseHistory() throws IOException {
        App.setRoot("viewPurchaseHistory");
    }
    @FXML private void exitButton() throws IOException {
        App.exit();
    }

    // FOR TESTING
    @FXML private void clearDataButton() throws IOException {
        DataHandler.clearAllData();
        DataHandler.initialiseProductData();
    }


    // TESTING IMAGE PATHS
    @FXML private void testButton () throws IOException {
        /*
        StringBuilder sb = new StringBuilder();
        for (Product product : DataHandler.products) {
            sb.append(product.getImagePath());
            sb.append("\n");
        }


        Utils.Text.showConfirmation(sb.toString());

         */
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUserLabel.textProperty().bind(DataHandler.loggedInUsername);
    }


}
