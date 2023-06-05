package com.mycompany.botanyhub.User;

import com.mycompany.botanyhub.DataHandler;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUtils {

    // Login the user if credentials match.
    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        Optional<? extends User> foundUser = users
            .stream()
            .filter(user -> user.getUsername().equals(inputtedUsername) && user.getPassword().equals(inputtedPassword))
            .findFirst();

        if (foundUser.isPresent()) {
            DataHandler.setUserStatus(foundUser.get(), foundUser.get().getUsername());
        } else {
            throw new Exception("Error while logging in\n" +
                    "Invalid username or password");
        }
    }


    // Logout the current user.
    public static void logout() {
        DataHandler.clearCurrentUser();
    }

    // Checks if a username exists
    public static boolean usernameExists(String usernameInput, ArrayList<? extends User> users) {
        return users
                .stream()// abstract stream
                .map(User::getUsername)// converts stream of user objects into stream of usernames
                .collect(Collectors.toList()) // converts stream into list
                .contains(usernameInput); // returns true if usernameInput exists in list of usernames
    }

    // Checks if a password is valid
    public static boolean isValidPassword(String inputtedPassword) {
        return !(inputtedPassword.isEmpty()
                || inputtedPassword.contains(" ")
                || inputtedPassword.contains("\""));
    }

} // END OF UserUtils class
