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

/**
 * FXML Controller class
 *
 * @author tqt13
 */
public class ViewIndividualProductController implements Initializable {

    @FXML private TextArea productDetailsTextArea;
    public static String currentProductName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setProduct(currentProductName);
    }    

    private void setProduct(String name) {
        productDetailsTextArea.setText(name);
    }




    @FXML private void backButton() throws IOException {
        App.setRoot("viewProducts");
    }
}
