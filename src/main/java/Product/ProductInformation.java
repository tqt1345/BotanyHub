package Product;

import javafx.scene.image.Image;

import java.io.Serializable;

public class ProductInformation implements Serializable {
    private String name;
    private String description;
    private double price;
    private String imagePath;

    public ProductInformation(String name, String description, double price, String imagePath){
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getPrice(){
        return this.price;
    }
    public Image getImage(){
        return new Image(this.imagePath);
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(double price){
        this.price = price;
    }


}
