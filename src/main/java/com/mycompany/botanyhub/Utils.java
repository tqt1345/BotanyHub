package com.mycompany.botanyhub;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import User.*;

public class Utils {
    public static class Text { // Various text and alert methods

        /*
        public static String separator(int count) {
            return ("*" + "~".repeat(count) + "*");
        }

         */

        // Displays a confirmation message as a JavaFX alert
        public static void showConfirmation(String message) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
            alert.showAndWait();
        }

        // Displays an error message as a JavaFX alert
        public static void showError(String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR, message);
            alert.showAndWait();
        }

        // Clears all TextField objects in an array
        public static void clearFields(TextField[] fields) {
            for (TextField field : fields) {
                field.clear();
            }
        }
    } // END OF TEXT CLASS

}
