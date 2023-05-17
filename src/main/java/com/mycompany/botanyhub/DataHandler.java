package com.mycompany.botanyhub;
import User.*;
import Product.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataHandler {

   // Users
   public static ArrayList<Customer> customers = new ArrayList<>();
   public static ArrayList<Administrator> administrators = new ArrayList<>();

   // Products
   public static ArrayList<Tool> tools = new ArrayList<>();
   public static ArrayList<Plant> plants = new ArrayList<>();

   // User status
   public static User currentUser;
   public static StringProperty currentUsername = new SimpleStringProperty("Current user: Not logged in");

   public static void setCurrentUsername(String username) {
      currentUsername.set(username);
   }

   public static void initialiseProductData() {

      tools.add(new Tool("Pruning Shears", "A pair of shears used for pruning plants.", 25));
      tools.add(new Tool("Shovel", "A tool used for digging holes.", 50));
      tools.add(new Tool("Watering Can", "A tool used for watering plants.", 15));

      plants.add(new Plant("Bonsai Tree", "A small tree grown in a pot.", 150));
      plants.add(new Plant("Bamboo Plant", "A spiky plant.", 20));
      plants.add(new Plant("Papaya Plant", "A flower.", 10));

   }

   public static void saveData() {
      try {
         FileOutputStream file = new FileOutputStream("data.ser");
         ObjectOutputStream output = new ObjectOutputStream(file);

         // Write arrays to file
         output.writeObject(customers);
         output.writeObject(administrators);
         output.writeObject(tools);
            output.writeObject(plants);

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

         file.close();
         input.close();

      } catch (Exception e) {
         // Creates a new data file if one doesn't exist
         Utils.Text.showConfirmation("No data file, creating new file.\n");
         saveData();
      }
   }

   public static void setCurrentUser(User user, String username) {
      DataHandler.currentUser = user;
      DataHandler.setCurrentUsername("Current user: " + username);
   }
}
