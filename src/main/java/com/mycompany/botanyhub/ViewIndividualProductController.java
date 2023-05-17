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
import javafx.scene.control.TextArea;

import Product.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewIndividualProductController implements Initializable {

    @FXML private TextArea productDetailsTextArea;
    public static String currentProductName;
    @FXML private static ImageView currentProductImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setProduct(currentProductName);

    }    

    private void setProduct(String name) {
        try {
            final String PRODUCT_DETAILS = ProductUtils.getProduct(name,DataHandler.products).toString();
            final Image PRODUCT_IMAGE = ProductUtils.getProduct(name,DataHandler.products).getImage();
            productDetailsTextArea.setText(PRODUCT_DETAILS);
            currentProductImage.setImage(PRODUCT_IMAGE);
        } catch (Exception e) {
            Utils.Text.showError("Error fetching product details: " + e.getMessage());
        }
    }


    @FXML private void backButton() throws IOException {
        App.setRoot("viewProducts");
    }
}
