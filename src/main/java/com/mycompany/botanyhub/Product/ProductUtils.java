package com.mycompany.botanyhub.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductUtils {

    public static Product getProductFromName(String inputtedName, ArrayList<? extends Product> products) throws Exception {
        return products
                .stream()
                .filter(product -> product.getName().equals(inputtedName))
                .findFirst()
                .orElseThrow( () -> new Exception(String.format("Error while getting product\n" +
                                    "Could not find product with name: %s", inputtedName)));
    }

    public static ObservableList<String> getProductNamesAsObservableList (List<? extends Product> products) {
        return products
                .stream()
                .map(Product::getName)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }
} // END OF ProductUtils class
