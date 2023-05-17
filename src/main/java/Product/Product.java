package Product;

import java.io.Serializable;

public class Product implements Serializable {
    final private ProductInformation PRODUCT_INFORMATION;

    public Product(String name, String description, double price) {
        this.PRODUCT_INFORMATION = new ProductInformation(name, description, price);
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

    public void setName(String name) {
        this.PRODUCT_INFORMATION.setName(name);
    }

    public void setDescription(String description) {
        this.PRODUCT_INFORMATION.setDescription(description);
    }

    public void setPrice(double price) {
        this.PRODUCT_INFORMATION.setPrice(price);
    }

}
