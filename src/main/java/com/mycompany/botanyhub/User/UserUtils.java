package com.mycompany.botanyhub.User;

import com.mycompany.botanyhub.DataHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        //throw new Exception("Invalid username or password");

       /* final boolean CREDENTIALS_MATCHED = users.stream()
                .anyMatch(user -> user.getUsername().equals(inputtedUsername) && user.getPassword().equals(inputtedPassword));*/


    }

    // Logout the current user.
    public static void logout() {
        DataHandler.setUserStatus(null, "Not logged in");
    }

    // Checks if a username exists
    public static boolean usernameExists(String usernameInput, ArrayList<? extends User> users) {
        /*boolean exists = false;
        for (User user : users) {
            final boolean USERNAME_EXISTS = usernameInput.equals(user.getUsername());
            if (USERNAME_EXISTS) {
                exists = true;
            }
        }
        return exists;*/

        return users.stream()
                .map(User::getUsername)
                .collect(Collectors.toList())
                .contains(usernameInput);
    }

    // Checks if a password is valid
    public static boolean isValidPassword(String inputtedPassword) {
        boolean isValid = true;
        if (inputtedPassword.isEmpty()) {
            isValid = false;
        }
        if (inputtedPassword.contains(" ")) {
            isValid = false;
        }
        return isValid;
    }

}
