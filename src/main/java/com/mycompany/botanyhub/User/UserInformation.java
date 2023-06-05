/*
Programmer: Tarique Turnbull
StudentID: 12177936
Course: COIT11134 Object-Oriented Programming
Assessment: Final Project

This class holds user information
 */

package com.mycompany.botanyhub.User;
import java.io.Serializable;

public abstract class UserInformation implements Serializable {
    private String username;
    private String password;

    public UserInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

}
