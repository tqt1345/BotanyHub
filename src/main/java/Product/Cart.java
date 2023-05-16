package Product;

import java.util.ArrayList;

public class Cart {

    ArrayList<Product> products = new ArrayList<Product>();
    public void addProduct(Product product) {
        products.add(product);
    }
}
