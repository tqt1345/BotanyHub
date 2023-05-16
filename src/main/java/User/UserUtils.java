package User;

import com.mycompany.botanyhub.DataHandler;

import java.util.ArrayList;

public class UserUtils {

    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        for (User user : users) {
            final String STORED_USERNAME = user.getUsername();
            final String STORED_PASSWORD = user.getPassword();

            if (inputtedUsername.equals(STORED_USERNAME) && inputtedPassword.equals(STORED_PASSWORD)) {
                DataHandler.setCurrentUser(user, inputtedUsername);
                return;
            }
        }
        throw new Exception("Invalid username or password");
    }

    public static boolean usernameExists(String usernameInput) {
        boolean exists = false;
        for (User customer : DataHandler.customers) {
            String usernameInList = customer.getUsername();
            if (usernameInput.equals(usernameInList)) {
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
