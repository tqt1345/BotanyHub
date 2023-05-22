/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.botanyhub.App;
import com.mycompany.botanyhub.DataHandler;
import com.mycompany.botanyhub.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    private static String previousPage;

    public static void setPreviousPage(String page) {
        previousPage = page;
    }
    @FXML private void switchToMainMenu() throws Exception {
        App.setRoot(previousPage);
    }

    // Assigns clicked product details to viewIndividualProduct controller and switches to it
    @FXML private void handleImageClick(MouseEvent clickEvent) throws IOException {
        ImageView clickedImage = (ImageView) clickEvent.getSource();
        final String CLICKED_PRODUCT_NAME = clickedImage.getId();
        ViewIndividualProductController.currentProductName = CLICKED_PRODUCT_NAME;
        Utils.Text.showConfirmation("Clicked on: " + CLICKED_PRODUCT_NAME);
        App.setRoot("viewIndividualProduct");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUserLabel.textProperty().bind(DataHandler.loggedInUsername);

        final String PRUNE_SHEARS_NAME = DataHandler.tools.get(0).getName();
        final String SHOVEL_NAME = DataHandler.tools.get(1).getName();
        final String WATERING_CAN_NAME = DataHandler.tools.get(2).getName();
        final String BONSAI_TREE_NAME = DataHandler.plants.get(0).getName();
        final String PAPAYA_TREE_NAME = DataHandler.plants.get(1).getName();
        final String BAMBOO_PLANT_NAME = DataHandler.plants.get(2).getName();

        pruningShearsToolImage.setId(PRUNE_SHEARS_NAME);
        shovelToolImage.setId(SHOVEL_NAME);
        wateringCanToolImage.setId(WATERING_CAN_NAME);
        bonsaiTreePlantImage.setId(BONSAI_TREE_NAME);
        papayaPlantImage.setId(PAPAYA_TREE_NAME);
        bambooPlantImage.setId(BAMBOO_PLANT_NAME);
    }
}