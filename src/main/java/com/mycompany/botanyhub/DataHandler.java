package com.mycompany.botanyhub;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import User.*;
import Product.*;
import javax.imageio.ImageIO;


public class DataHandler {
   public static ArrayList<Customer> customers = new ArrayList<>();
   public static ArrayList<Administrator> administrators = new ArrayList<>();


   // Products
   public static ArrayList<Tool> tools = new ArrayList<>();
   public static ArrayList<Plant> plants = new ArrayList<>();
   public static ArrayList<Product> products = new ArrayList<>();

   // User status
   public static User currentUser;
   public static StringProperty currentUsername = new SimpleStringProperty("Current user: Not logged in");

   // Images
   public static String pruningShearsImage = "src/main/resources/images/pruningShearsTool.jpg";
   public static String shovelImage = "src/main/resources/images/shovelTool.jpg";
   public static String wateringCanImage = "src/main/resources/images/wateringCanTool.jpg";
   public static String bonsaiTreeImage = "src/main/resources/images/bonsaiTreePlant.jpg";
   public static String bambooPlantImage = "src/main/resources/images/bambooPlant.jpg";
   public static String papayaPlantImage = "src/main/resources/images/papayaPlant.jpg";

   public static void setCurrentUser(User user, String username) {
      currentUser = user;
      currentUsername.set(username);
   }

   public static void initialiseProductData() {

      tools.add(new Tool("Pruning Shears", "A pair of shears used for pruning plants.", 25, pruningShearsImage)); // POS 0
      tools.add(new Tool("Shovel", "A tool used for digging holes.", 50,shovelImage));                   // POS 1
      tools.add(new Tool("Watering Can", "A tool used for watering plants.", 15,wateringCanImage));           // POS 2

      plants.add(new Plant("Bonsai Tree", "A small tree grown in a pot.", 150,bonsaiTreeImage));             // POS 0
      plants.add(new Plant("Bamboo Plant", "tmp.", 20,bambooPlantImage));                           // POS 1
      plants.add(new Plant("Papaya Plant", "tmp.", 10,papayaPlantImage));

      products.addAll(tools);
      products.addAll(plants);

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
         Utils.Text.showConfirmation("No data file, creating new file.\n");
         saveData();
      }
   }

   public static void clearAllData() {
        clearProductData();
        clearUserData();
   }

   public static void clearProductData() {
        tools.clear();
        plants.clear();
        products.clear();
   }

    public static void clearUserData() {
          customers.clear();
          administrators.clear();
    }

}
