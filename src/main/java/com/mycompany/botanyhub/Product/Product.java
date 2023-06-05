/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class controls functionality for Products
 */

package com.mycompany.botanyhub.Product;
import java.io.Serializable;

public class Product implements Serializable {
    final private ProductInformation PRODUCT_INFORMATION;

    // Product constructor
    public Product(String name, String description, double price) {
        this.PRODUCT_INFORMATION = new ProductInformation(name, description, price);
    }

    // Getters
    public String getName() {return this.PRODUCT_INFORMATION.getName();}
    public String getDescription() {return this.PRODUCT_INFORMATION.getDescription();}
    public double getPrice() {return this.PRODUCT_INFORMATION.getPrice();}

    // Setters
    public void setName(String name) {this.PRODUCT_INFORMATION.setName(name);}
    public void setDescription(String description) {this.PRODUCT_INFORMATION.setDescription(description);}
    public void setPrice(double price) {this.PRODUCT_INFORMATION.setPrice(price);}

    @Override
    public String toString() {
        return "Product Name: " + this.PRODUCT_INFORMATION.getName() + "\n" +
                "Product Description: " + this.PRODUCT_INFORMATION.getDescription() + "\n" +
                "Product Price: $" + this.PRODUCT_INFORMATION.getPrice() + "\n";
    }
}
