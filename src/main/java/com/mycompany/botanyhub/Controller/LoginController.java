/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.App;
import com.mycompany.botanyhub.DataHandler;
import com.mycompany.botanyhub.User.UserUtils;
import com.mycompany.botanyhub.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class LoginController implements Initializable {

    // TextFields
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    private TextField[] inputFields;

    StringBuilder errorMessage; // Holds error messages

    // Handles login functionality
    @FXML private void loginButton() {
        final String USERNAME = usernameField.getText();
        final String PASSWORD = passwordField.getText();
        final boolean ALREADY_LOGGED_IN = DataHandler.loggedInUser != null;
        try {
            if (ALREADY_LOGGED_IN) {
                throw new Exception("You are already logged in to an account\n Please logout first to switch accounts.");
            }
            UserUtils.login(USERNAME, PASSWORD, DataHandler.customers);
            Utils.Text.showConfirmation("Login successful");
            Utils.Text.clearFields(inputFields);
        } catch (Exception e) {
            Utils.Text.showError(e.getMessage());
        }
    }

    @FXML private void switchToMainMenu() throws Exception {
        App.setRoot("mainMenu");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputFields = new TextField[]{usernameField, passwordField};
        errorMessage = new StringBuilder();
    }

}

