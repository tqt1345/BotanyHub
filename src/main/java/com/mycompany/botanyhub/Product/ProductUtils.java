package com.mycompany.botanyhub.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductUtils {

    public static Product getProduct (String inputtedName, List<? extends Product> products) throws Exception {
        for (Product product : products) {
            if (product.getName().equals(inputtedName)) {
                return product;
            }
        }
        throw new Exception(String.format("Error while getting product\n" +
                "Product with name: %s not found inside inputted list", inputtedName));
    }

    public static ObservableList<String> getProductNamesAsObservableList (List<? extends Product> products) {
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (Product product : products) {
            productNames.add(product.getName());
        }
            return productNames;
    }
}
