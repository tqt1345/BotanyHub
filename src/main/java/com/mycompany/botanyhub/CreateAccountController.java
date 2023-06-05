
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.Customer;
import com.mycompany.botanyhub.User.User;
import com.mycompany.botanyhub.User.UserUtils;
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

    StringBuilder errorMessage = new StringBuilder();   // Holds error messages
    private static String previousPage;                 // Holds previous page FXML

    // Submit button creates a new user
    @FXML private void submitButton () {
        try {
            final boolean LOGGED_IN = DataHandler.loggedInUser != null;
            if (LOGGED_IN) {
                Utils.Text.showError("Please logout before creating a new account.");
                return;
            }

            final String USERNAME = usernameField.getText();
            final String PASSWORD = passwordField.getText();
            if (isValidInput(USERNAME, PASSWORD, DataHandler.customers)) {
                Customer newCustomer = makeCustomer(USERNAME, PASSWORD);
                DataHandler.customers.add(newCustomer);
                Utils.Text.showConfirmation("Account created successfully");
                Utils.Text.clearFields(inputFields);
            } else {
                Utils.Text.showError(errorMessage.toString());
                clearErrorMessage();
            }
        } catch (Exception e) {
            Utils.Text.showError("Error creating account\n" + e.getMessage());
        }
    }

    /* Validation checks for input when creating a new account:
        - Is the username empty?
        - Does the username contain spaces?
        - Does the username contain quotation marks?
        - Does the username already exist?
        - Is the password empty?
        - Does the password contain spaces?
     */
    private boolean isValidInput(String username, String password, ArrayList<? extends User> userList) {
        boolean isValid = true;
        boolean usernameIsEmpty = username.isEmpty();
        boolean usernameContainsSpacesOrQuotations = username.contains(" ") || username.contains("\"");
        boolean usernameExists = UserUtils.usernameExists(username, userList);
        boolean passwordIsNotValid = !UserUtils.isValidPassword(password);

        if (usernameIsEmpty) {
            errorMessage.append("Username cannot be empty\n");
            isValid = false;
        }
        if (usernameContainsSpacesOrQuotations) {
            errorMessage.append("Username cannot contain spaces or quotations\n");
            isValid = false;
        }
        if (usernameExists) {
            errorMessage.append("Username already exists\n");
            isValid = false;
        }
        if (passwordIsNotValid) {
            errorMessage.append("Password cannot be empty or contain spaces\n");
            isValid = false;
        }
    return isValid;
    }

    // Builds and returns new customer object
    private Customer makeCustomer(String username, String password) {
        return new Customer(username, password);
    }

    private void clearErrorMessage() {
        errorMessage.setLength(0);
    }

    public static void setPreviousPage (String page) {
        previousPage = page;
    }
    @FXML private void backButton() throws IOException {
        App.setRoot(previousPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputFields = new TextField[] {usernameField, passwordField};
        previousPage = "mainMenu";
    }
}
