package Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    ArrayList<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        products.add(product);
    }
}
