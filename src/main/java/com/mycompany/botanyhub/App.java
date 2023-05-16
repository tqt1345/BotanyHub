package com.mycompany.botanyhub;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            DataHandler.loadData();
            scene = new Scene(loadFXML("mainMenu"));
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(windowEvent -> {
                exit();
            });

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void exit() {
        DataHandler.saveData();
        Platform.exit();

    }

    public static void main(String[] args) {
        launch();
    }

}