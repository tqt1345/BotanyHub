package Product;

import javafx.scene.image.Image;

import java.io.Serializable;

public class ProductInformation implements Serializable {
    private String name;
    private String description;
    private double price;
    private transient Image image; // Image does not implement Serializable. Marked as transient to ignore serialization.

    public ProductInformation(String name, String description, double price, Image image){
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
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
        return this.image;
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
    public void setImage(Image image){
        this.image = image;
    }

}
