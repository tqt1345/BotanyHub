/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewCartController implements Initializable {

    @FXML private Label currentUserLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUserLabel.textProperty().bind(DataHandler.currentUsername);

    }

    @FXML
    private void switchToMainMenu() throws Exception {
        App.setRoot("mainMenu");
    }
}
