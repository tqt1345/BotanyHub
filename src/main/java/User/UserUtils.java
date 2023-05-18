package User;

import Product.Product;
import com.mycompany.botanyhub.DataHandler;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import Product.*;

public class UserUtils {

    // Login the user if credentials match.
    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        for (User user : users) {
            final boolean CREDENTIALS_MATCHED = inputtedUsername.equals(user.getUsername()) && inputtedPassword.equals(user.getPassword());
            if (CREDENTIALS_MATCHED) {
                DataHandler.setUserStatus(user, inputtedUsername);
                return;
            }
        }
        throw new Exception("Invalid username or password");
    }

    // Logout the current user.
    public static void logout() {
        DataHandler.setUserStatus(null, "Not logged in");
    }

    // Checks if a username exists
    public static boolean usernameExists(String usernameInput, ArrayList<? extends User> users) {
        boolean exists = false;
        for (User user : users) {
            final boolean USERNAME_EXISTS = usernameInput.equals(user.getUsername());
            if (USERNAME_EXISTS) {
                exists = true;
            }
        }
        return exists;
    }

    // Checks if a password is valid
    public static boolean isValidPassword(String password) {
        boolean isValid = true;
        if (password.isEmpty()) {
            isValid = false;
        }
        if (password.contains(" ")) {
            isValid = false;
        }
        return isValid;
    }

    /*
    public static ObservableList<String> showCart () {
        final ArrayList<Product> PRODUCTS_IN_CART = DataHandler.loggedInUser.getCart();
        return ProductUtils.getProductNamesAsObservableList(PRODUCTS_IN_CART);
    }

    public static ObservableList<String> showPurchaseHistory () {
        final ArrayList<Product> PURCHASE_HISTORY = DataHandler.loggedInUser.getPurchaseHistory();
        return ProductUtils.getProductNamesAsObservableList(PURCHASE_HISTORY);
    }

     */
}
