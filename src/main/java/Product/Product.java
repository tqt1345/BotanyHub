package Product;


import javafx.scene.image.Image;

import java.io.Serializable;

public class Product implements Serializable {
    final private ProductInformation PRODUCT_INFORMATION;

    public Product(String name, String description, double price, Image image) {
        this.PRODUCT_INFORMATION = new ProductInformation(name, description, price,image);
    }

    public String getName() {
        return this.PRODUCT_INFORMATION.getName();
    }

    public String getDescription() {
        return this.PRODUCT_INFORMATION.getDescription();
    }

    public double getPrice() {
        return this.PRODUCT_INFORMATION.getPrice();
    }

    public Image getImage() {
        return this.PRODUCT_INFORMATION.getImage();
    }

    public void setName(String name) {
        this.PRODUCT_INFORMATION.setName(name);
    }

    public void setDescription(String description) {
        this.PRODUCT_INFORMATION.setDescription(description);
    }

    public void setPrice(double price) {
        this.PRODUCT_INFORMATION.setPrice(price);
    }

    @Override
    public String toString() {
        return "Product Name: " + this.PRODUCT_INFORMATION.getName() + "\n" +
                "Product Description: " + this.PRODUCT_INFORMATION.getDescription() + "\n" +
                "Product Price: $" + this.PRODUCT_INFORMATION.getPrice() + "\n";
    }
}
