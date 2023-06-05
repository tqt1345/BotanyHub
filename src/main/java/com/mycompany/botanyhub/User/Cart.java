/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls functionality cart objects
 */

package com.mycompany.botanyhub.User;
import com.mycompany.botanyhub.Product.Product;
import com.mycompany.botanyhub.Product.ProductUtils;
import javafx.collections.ObservableList;
import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    ArrayList<Product> cart;

    public Cart () {
        this.cart = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        this.cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        this.cart.remove(product);
    }

    public ArrayList<Product> getCart() {
        return this.cart;
    }

    public ObservableList<String> getProductNamesInCart() {
        return ProductUtils.getProductNamesAsObservableList(this.cart);
    }

    public double getTotalCostOfCart() {
        return this.cart.stream()
                        .mapToDouble(Product::getPrice)
                        .sum();
    }
}
