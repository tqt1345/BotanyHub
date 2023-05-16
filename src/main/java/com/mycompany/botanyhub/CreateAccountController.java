
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import User.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class CreateAccountController implements Initializable {

    // TextFields
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    // TextField arrays
    private TextField[] inputFields;

    StringBuilder errorMessage = new StringBuilder();

    @FXML private void submitButton () {
        try {
            final String USERNAME = usernameField.getText();
            final String PASSWORD = passwordField.getText();

            if (isValidInput(USERNAME, PASSWORD)) {
                DataHandler.customers.add(makeCustomer());
                Utils.Text.showConfirmation("Account created successfully");
                Utils.Text.clearFields(inputFields);
            } else {
                Utils.Text.showError(errorMessage.toString());
                clearErrorMessage();
            }
        } catch (Exception e) {
            Utils.Text.showError(e.getMessage());
        }
    }

    private boolean isValidInput(String username, String password) {
        boolean isValid = true;

        if (username.isEmpty()) {
            errorMessage.append("Username cannot be empty\n");
            isValid = false;
        }
        if (username.contains(" ") || username.contains("\"")) {
            errorMessage.append("Username cannot contain spaces or quotations\n");
            isValid = false;
        }
        if (UserUtils.usernameExists(username, DataHandler.customers)) {
            errorMessage.append("Username already exists\n");
            isValid = false;
        }
        if (!UserUtils.isValidPassword(password)) {
            errorMessage.append("Password cannot be empty or contain spaces\n");
            isValid = false;
        }
        return isValid;
    }

    private Customer makeCustomer() {
        final String USERNAME = usernameField.getText();
        final String PASSWORD = passwordField.getText();

        return new Customer(USERNAME, PASSWORD);
    }

    private void clearErrorMessage() {
        errorMessage.setLength(0);
    }

    @FXML private void switchToMainMenu() throws IOException {
        App.setRoot("mainMenu");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputFields = new TextField[] {usernameField, passwordField};
    }
}
