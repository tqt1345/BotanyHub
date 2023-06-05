/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class holds information about a product.
 */

package com.mycompany.botanyhub.Product;
import java.io.Serializable;

public class ProductInformation implements Serializable {
    private String name;
    private String description;
    private double price;

    public ProductInformation(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public double getPrice(){return this.price;}

    // Setters
    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setPrice(double price){this.price = price;}
}
