package com.mycompany.botanyhub.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ProductUtils {


    public static Product getProduct (String inputtedName, ArrayList<? extends Product> inputtedProductList) throws Exception {
        return inputtedProductList.stream()
                .filter(product -> product.getName().equals(inputtedName)).findFirst()
                .orElseThrow( () -> new Exception(String.format("Error while getting product\n" +
                        "Could not find product with name: %s", inputtedName)));
    }

   /* public static Product getProductOld (String inputtedName, List<? extends Product> products) throws Exception {
        for (Product product : products) {
            if (product.getName().equals(inputtedName)) {
                return product;
            }
        }
        throw new Exception(String.format("Error while getting product\n" +
                "Product with name: %s not found inside inputted list", inputtedName));
    }*/

    public static ObservableList<String> getProductNamesAsObservableList (List<? extends Product> products) {
        ObservableList<String> productNames = FXCollections.observableArrayList();
        for (Product product : products) {
            productNames.add(product.getName());
        }
            return productNames;
    }
}
