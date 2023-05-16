/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class MainMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML private void switchToCreateAccount() throws IOException {
        App.setRoot("createAccount");
    }

    @FXML private void switchToLogin() throws IOException {
        App.setRoot("login");
    }

    @FXML private void switchToLogout() throws IOException {
        App.setRoot("logout");
    }

    @FXML private void switchToViewProducts() throws IOException {
        App.setRoot("viewProducts");
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

}
