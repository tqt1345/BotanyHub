package User;

import com.mycompany.botanyhub.DataHandler;

import java.util.ArrayList;

public class UserUtils {

    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        for (User user : users) {
            final boolean CREDENTIALS_MATCHED = inputtedUsername.equals(user.getUsername()) && inputtedPassword.equals(user.getPassword());
            if (CREDENTIALS_MATCHED) {
                DataHandler.setCurrentUser(user, inputtedUsername);
                return;
            }
        }
        throw new Exception("Invalid username or password");
    }

    public static void logout() {
        DataHandler.setCurrentUser(null, "Not logged in");
    }

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
    public static void loginOld (String username, String password) throws Exception {
        User currentUser = getUserWithCredentials(username, password, DataHandler.customers);
        DataHandler.setCurrentUser(currentUser,username);
    }

     */
}
