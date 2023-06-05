/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

Abstract User class exists for polymorphism and potential expansion of User types beyond Customers.
 */

package com.mycompany.botanyhub.User;
public abstract class User {

    public User() {
    }
    abstract String getUsername();
    abstract String getPassword();
}
