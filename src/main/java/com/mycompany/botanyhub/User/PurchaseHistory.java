/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls functionality for a customer's purchase history
 */

package com.mycompany.botanyhub.User;
import java.io.Serializable;
import java.util.ArrayList;
import com.mycompany.botanyhub.Product.Product;

public class PurchaseHistory implements Serializable {
    ArrayList<Product> purchaseHistory;

    public PurchaseHistory() {
        this.purchaseHistory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.purchaseHistory.add(product);
    }

    public ArrayList<Product> getPurchaseHistory() {
        return this.purchaseHistory;
    }
}
