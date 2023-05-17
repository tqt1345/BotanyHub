package Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    ArrayList<Product> cart;

    public Cart () {
        this.cart = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        this.cart.add(product);
    }

    public ArrayList<Product> getCart() {
        return this.cart;
    }
}
