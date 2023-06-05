/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls main menu functionality
 */

package com.mycompany.botanyhub;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.UserUtils;
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
        CreateAccountController.setPreviousPage("mainMenu");
    }

    @FXML private void switchToLogin() throws IOException {
        App.setRoot("login");
        LoginController.setPreviousPage("mainMenu");
    }

    // Facilitates logout
    @FXML private void logoutButton() {
        try {
            final boolean USER_LOGGED_IN = DataHandler.loggedInUser != null;
            if (USER_LOGGED_IN) {
                Utils.Text.runIfConfirmedByUser (
                        "Logout Confirmation",
                        "Are you sure you want to logout?",
                        "Ok to logout",
                        () -> {
                            UserUtils.logout();
                            Utils.Text.showConfirmation("Logout successful");
                        });
            } else {
                throw new Exception("Can't perform action:\n No user is currently logged in");
            }
        } catch (Exception e){
            Utils.Text.showError(e.getMessage());
        }
    }

    @FXML private void switchToViewProducts() {
        try {
            App.setRoot("viewProducts");
            ViewProductsController.setPreviousPage("mainMenu");

        } catch (Exception e) {
            Utils.Text.showError(e.getMessage());
        }
    }
    @FXML private void switchToViewCart() throws IOException {
        App.setRoot("viewCart");
        ViewCartController.setPreviousPage("mainMenu");
    }
    @FXML private void switchToViewPurchaseHistory() throws IOException {
        App.setRoot("viewPurchaseHistory");
        ViewPurchaseHistoryController.setPreviousPage("mainMenu");
    }
    @FXML private void exitButton() {
        App.exit();
    }

    // FOR TESTING: Clears all data
    @FXML private void clearDataButton() {
        Utils.Text.runIfConfirmedByUser (
                "Clear Data Confirmation",
                "This will wipe all program data. Are you sure?",
                "Press Ok to proceed",
                () -> {
                    DataHandler.clearAllData();
                    DataHandler.initialiseProductData();
                    Utils.Text.showConfirmation("Successfully cleared data");
                });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUserLabel.textProperty().bind(DataHandler.loggedInUsername);
    }


}
