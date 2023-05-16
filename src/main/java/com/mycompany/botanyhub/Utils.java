package com.mycompany.botanyhub;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import User.*;

public class Utils {
    public static class Text { // Various text and alert methods

        // Prints a separator line
        public static String separator(int count) {
            return ("*" + "~".repeat(count) + "*");
        }

        public static void showConfirmation(String message) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
            alert.showAndWait();
        }

        public static void showError(String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }

        public static void clearFields(TextField[] fields) {
            for (TextField field : fields) {
                field.clear();
            }
        }
    } // END OF TEXT CLASS

    public static class Validator {
        public static boolean isValidUsername(String username) {
            boolean isValid = true;

            if (usernameExists(username)) {
                isValid = false;
            }
            if (username.isEmpty()) {
                isValid = false;
            }
            if (username.contains(" ")) {
                isValid = false;
            }
            return isValid;
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
    } // END OF VALIDATOR CLASS
}
