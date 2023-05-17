package Product;

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

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public double getPrice(){
        return this.price;
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
