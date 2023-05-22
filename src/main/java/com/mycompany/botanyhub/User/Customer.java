package com.mycompany.botanyhub.User;

import com.mycompany.botanyhub.Product.Product;
import javafx.collections.ObservableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Customer extends User implements Serializable {

    private final CustomerInformation customerInformation;
    private final Cart cart;
    private final PurchaseHistory purchaseHistory;

    public Customer (String username, String password){
        this.customerInformation = new CustomerInformation(username, password);
        this.cart = new Cart();
        this.purchaseHistory = new PurchaseHistory();
    }

    // Username and password manipulation
    public String getUsername() {
        return this.customerInformation.getUsername();
    }

    public String getPassword() {
        return this.customerInformation.getPassword();
    }

    // Cart manipulation

    // Gets the user's cart as an ArrayList of Products
    public ArrayList<Product> getCart() {
        return this.cart.getCart();
    }

    // Gets the total cost of all products in the user's cart
    public double getTotalCost() {
        return this.cart.getTotalCost();
    }

    // Adds a product to the user's cart
    public void addProductToCart(Product product) {
        this.cart.addProductToCart(product);
    }

    // Returns the names of each product in the user's cart as an ObservableList
    public ObservableList<String> getProductNamesInCart() {
        return this.cart.getProductNamesInCart();
    }


    // Purchase manipulation

    // Removes all products in the user's cart and adds them to the user's purchase history
    public void makePurchase() {
        Iterator<Product> iterator = this.cart.getCart().iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            this.purchaseHistory.addProduct(product);
            iterator.remove();
        }
    }

    // Returns the user's purchase history as an ArrayList of products
    public ArrayList<Product> getPurchaseHistory() {
        return this.purchaseHistory.getPurchaseHistory();
    }

    // Returns the names of each product in the user's purchase history as an ObservableList
    public ObservableList<String> getProductNamesInPurchaseHistory() {
        return this.purchaseHistory.getProductNamesInPurchaseHistory();
    }

    // Displays user details
    @Override
    public String toString() {
        return "Username: " + this.customerInformation.getUsername() + "\n" +
                "Password: " + this.customerInformation.getPassword() + "\n";
    }
}
