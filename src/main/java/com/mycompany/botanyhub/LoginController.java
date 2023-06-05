/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls functionality logging in to an existing account
 */

package com.mycompany.botanyhub;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.UserUtils;
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

    StringBuilder errorMessage;             // Holds error messages
    private static String previousPage;     // Holds previous page FXML

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

    public static void setPreviousPage(String page) {
        previousPage = page;
    }
    @FXML private void backButton() throws Exception {
        App.setRoot(previousPage);
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

