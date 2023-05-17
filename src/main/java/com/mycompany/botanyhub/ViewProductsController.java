/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewProductsController implements Initializable {

    @FXML private ImageView pruningShearsToolImage;
    @FXML private ImageView shovelToolImage;
    @FXML private ImageView wateringCanToolImage;
    @FXML private ImageView bonsaiTreePlantImage;
    @FXML private ImageView papayaPlantImage;
    @FXML private ImageView bambooPlantImage;




    @FXML private Label currentUserLabel;

    @FXML
    private void switchToMainMenu() throws Exception {
        App.setRoot("mainMenu");
    }

    @FXML private void viewProductOnClick() throws IOException {
        App.setRoot("viewIndividualProduct");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUserLabel.textProperty().bind(DataHandler.currentUsername);


    }
}
