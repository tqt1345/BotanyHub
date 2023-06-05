/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class holds customer information
 */

package com.mycompany.botanyhub.User;

public class CustomerInformation extends UserInformation {
    private static final String userType = "Customer";
    public CustomerInformation(String username, String password) {
        super(username, password);
    }
}
