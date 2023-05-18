/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.botanyhub;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    //@FXML private ImageView currentProductImage;

    private Product currentProduct;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setProduct(currentProductName);

    }    

    private void setProduct(String name) {
        try {
            currentProduct = ProductUtils.getProduct(name,DataHandler.products);
            productDetailsTextArea.setText(currentProduct.toString());

        } catch (Exception e) {
            Utils.Text.showError("Error fetching product details: " + e.getMessage());
        }
    }

    @FXML private void addToCart() {
        if (DataHandler.loggedInUser == null) {
            Utils.Text.showError("Can't add to cart, must be logged in.");
            return;
        }
        DataHandler.loggedInUser.addProductToCart(currentProduct);
        Utils.Text.showConfirmation("Successfully added product to cart");
    }

    @FXML private void backButton() throws IOException {
        App.setRoot("viewProducts");
    }
}
