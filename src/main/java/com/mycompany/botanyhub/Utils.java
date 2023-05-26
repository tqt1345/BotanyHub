package com.mycompany.botanyhub;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Utils {
    public static class Text { // Various text and alert methods

        // Displays a confirmation message as a JavaFX alert
        public static void showConfirmation(String message) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message);
            alert.showAndWait();
        }

        // Alert takes a lambda expression to run if ok button is pressed.
        public static void runIfConfirmedByUser(String title, String header, String content, Runnable onOkAction) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    onOkAction.run();
                }
            });
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
    }

}
