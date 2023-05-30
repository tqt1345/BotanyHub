package com.mycompany.botanyhub.User;

import com.mycompany.botanyhub.DataHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class UserUtils {

    // Login the user if credentials match.
    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        users.stream()
                .filter(user -> user.getUsername().equals(inputtedUsername) && user.getPassword().equals(inputtedPassword))
                .findFirst()
                .ifPresent(user -> DataHandler.setUserStatus(user, inputtedUsername));
        throw new Exception("Invalid username or password");
    }


    // Logout the current user.
    public static void logout() {
        DataHandler.setUserStatus(null, "Not logged in");
    }

    // Checks if a username exists
    public static boolean usernameExists(String usernameInput, ArrayList<? extends User> users) {
        return users.stream()
                .map(User::getUsername)
                .collect(Collectors.toList())
                .contains(usernameInput);
    }

    // Checks if a password is valid
    public static boolean isValidPassword(String inputtedPassword) {
        return !(inputtedPassword.isEmpty() || inputtedPassword.contains(" "));
    }

} // END OF UserUtils class
