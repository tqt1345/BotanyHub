/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import User.*;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class LoginController implements Initializable {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    private TextField[] inputFields;
    StringBuilder errorMessage;

    @FXML private void loginButton() {
        try {

            final String USERNAME = usernameField.getText();
            final String PASSWORD = passwordField.getText();

            UserUtils.login(USERNAME, PASSWORD);

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

