package com.mycompany.botanyhub.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductUtils {

    public static Product getProduct (String inputtedName, List<? extends Product> products) {
        for (Product product : products) {
            if (product.getName().equals(inputtedName)) {
                return product;
            }
        }
        return null;
    }

    public static ObservableList<String> getProductNamesAsObservableList (List<? extends Product> products) {
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }

}
