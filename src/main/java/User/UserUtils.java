package User;

import com.mycompany.botanyhub.DataHandler;

import java.util.ArrayList;

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
}
