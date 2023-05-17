package com.mycompany.botanyhub;
import User.*;
<<<<<<< Updated upstream
=======
import Product.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
>>>>>>> Stashed changes

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataHandler {
   public static ArrayList<Customer> customers = new ArrayList<>();
   public static ArrayList<Administrator> administrators = new ArrayList<>();

<<<<<<< Updated upstream
=======
   // Products
   public static ArrayList<Tool> tools = new ArrayList<>();
   public static ArrayList<Plant> plants = new ArrayList<>();
   public static ArrayList<Product> products = new ArrayList<>();

   // User status
   public static User currentUser;
   public static StringProperty currentUsername = new SimpleStringProperty("Current user: Not logged in");

   // Images
   public static Image bonsaiTreeImage = new Image("file:src/main/resources/images/bonsaiTree.jpg");
   public static Image bambooPlantImage = new Image("file:src/main/resources/images/bambooPlant.jpg");
   public static Image papayaPlantImage = new Image("file:src/main/resources/images/papayaPlant.jpg");
   public static Image pruningShearsImage = new Image("file:src/main/resources/images/pruningShears.jpg");
   public static Image shovelImage = new Image("file:src/main/resources/images/shovel.jpg");
   public static Image wateringCanImage = new Image("file:src/main/resources/images/wateringCan.jpg");

   public static void setCurrentUsername(String username) {
      currentUsername.set(username);
   }

   public static void initialiseProductData() {

      tools.add(new Tool("Pruning Shears", "A pair of shears used for pruning plants.", 25, pruningShearsImage)); // POS 0
      tools.add(new Tool("Shovel", "A tool used for digging holes.", 50,shovelImage));                   // POS 1
      tools.add(new Tool("Watering Can", "A tool used for watering plants.", 15,wateringCanImage));           // POS 2

      plants.add(new Plant("Bonsai Tree", "A small tree grown in a pot.", 150,bonsaiTreeImage));             // POS 0
      plants.add(new Plant("Bamboo Plant", "A spiky plant.", 20,bambooPlantImage));                           // POS 1
      plants.add(new Plant("Papaya Plant", "A flower.", 10,papayaPlantImage));

      products.addAll(tools);
      products.addAll(plants);


   }

>>>>>>> Stashed changes
   public static void saveData() {
      try {
         FileOutputStream file = new FileOutputStream("data.ser");
         ObjectOutputStream output = new ObjectOutputStream(file);

         // Write arrays to file
         output.writeObject(customers);
         output.writeObject(administrators);
<<<<<<< Updated upstream
=======
         output.writeObject(tools);
         output.writeObject(plants);
         output.writeObject(products);
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======
         tools = (ArrayList<Tool>) input.readObject();
         plants = (ArrayList<Plant>) input.readObject();
         products = (ArrayList<Product>) input.readObject();
>>>>>>> Stashed changes

         file.close();
         input.close();

      } catch (Exception e) {
         // Creates a new data file if one doesn't exist
         Utils.Text.showConfirmation("No data file, creating new file.\n");
         saveData();
      }
   }


}
