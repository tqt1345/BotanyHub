
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.mycompany.botanyhub.User.UserUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    @FXML private void logoutButton() throws Exception {
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
    }

    @FXML private void switchToViewProducts() throws IOException {
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
