package com.mycompany.botanyhub;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.*;
import java.util.ArrayList;
import User.*;
import Product.*;


public class DataHandler {

   // User Lists
   public static ArrayList<Customer> customers = new ArrayList<>();
   public static ArrayList<Administrator> administrators = new ArrayList<>();

   // User status
   public static User loggedInUser; // currently logged-in user
   private static final String DEFAULT_USER_STATUS = "Not Logged In";
   public static final StringProperty loggedInUsername = new SimpleStringProperty(DEFAULT_USER_STATUS);

   // Product Lists
   public static ArrayList<Tool> tools = new ArrayList<>();
   public static ArrayList<Plant> plants = new ArrayList<>();
   public static ArrayList<Product> products = new ArrayList<>();

   // Sets the user status with the user and username
   public static void setUserStatus(User user, String username) {
      loggedInUser = user;
      loggedInUsername.set("Logged in as: " + username);
   }

   // Creates the catalogue of products
   public static void initialiseProductData() {

      // Make tool products
      tools.add(new Tool("Pruning Shears", "A pair of shears used for pruning plants.", 25));   // POS 0
      tools.add(new Tool("Shovel", "A tool used for digging holes.", 50));                      // POS 1
      tools.add(new Tool("Watering Can", "A tool used for watering plants.", 15));              // POS 2

      // Make plant products
      plants.add(new Plant("Bonsai Tree", "A small tree grown in a pot.", 150));                // POS 0
      plants.add(new Plant("Bamboo Plant", "tmp.", 20));                                        // POS 1
      plants.add(new Plant("Papaya Plant", "tmp.", 10));                                        // POS 2

      // All products added to products list for easy access
      products.addAll(tools);
      products.addAll(plants);
   }

   // Saves all object arrays to a file via serialization
   public static void saveData() {
      try {
         FileOutputStream file = new FileOutputStream("data.ser");
         ObjectOutputStream output = new ObjectOutputStream(file);

         // Write arrays to file
         output.writeObject(customers);
         output.writeObject(administrators);
         output.writeObject(tools);
         output.writeObject(plants);
         output.writeObject(products);

         output.close();
      } catch (Exception e) {
         Utils.Text.showError("Error saving data\n" + e.getMessage());
      }
   }

   // Loads all object arrays from a file via deserialization
   public static void loadData() {
      try {
         FileInputStream file = new FileInputStream("data.ser");
         ObjectInputStream input = new ObjectInputStream(file);

         // Load arrays from file
         customers = (ArrayList<Customer>) input.readObject();
         administrators = (ArrayList<Administrator>) input.readObject();
         tools = (ArrayList<Tool>) input.readObject();
         plants = (ArrayList<Plant>) input.readObject();
         products = (ArrayList<Product>) input.readObject();

         file.close();
         input.close();

      } catch (Exception e) {
         // Creates a new data file if one doesn't exist
         Utils.Text.showConfirmation("No data file or data is corrupted, creating new file.\n");
         saveData();
      }
   }

   // Clears all data from data.ser file
   public static void clearAllData() {
        clearProductData();
        clearUserData();
   }

   // Clears all product data from data.ser file
   public static void clearProductData() {
        tools.clear();
        plants.clear();
        products.clear();
   }

    // Clears all user data from data.ser file
    public static void clearUserData() {
          customers.clear();
          administrators.clear();
          clearCurrentUser();
    }

    // Clears current user status
    public static void clearCurrentUser() {
       loggedInUser = null;
       loggedInUsername.set("Current user: Not logged in");
    }

}
