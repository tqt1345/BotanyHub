/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls various utility methods relating to User objects
 */

package com.mycompany.botanyhub.User;
import com.mycompany.botanyhub.DataHandler;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserUtils {

    // Login the user if credentials match.
    public static void login(String inputtedUsername, String inputtedPassword, ArrayList<? extends User> users) throws Exception {
        User foundUser = users
                .stream()
                .filter(user -> user.getUsername().equals(inputtedUsername) && user.getPassword().equals(inputtedPassword))
                .findFirst()
                .orElseThrow( () -> new RuntimeException("Invalid username or password"));
        DataHandler.setUserStatus(foundUser, foundUser.getUsername());
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
