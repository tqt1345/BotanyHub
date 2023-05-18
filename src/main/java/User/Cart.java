package User;

import Product.*;
import javafx.collections.ObservableList;

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

    public void removeProduct(Product product) {
        this.cart.remove(product);
    }

    public ArrayList<Product> getCart() {
        return this.cart;
    }

    public ObservableList<String> getProductNamesInCart() {
        return ProductUtils.getProductNamesAsObservableList(this.cart);
    }

    public double getTotalCost () {
        double total = 0;
        for (Product product : this.cart) {
            total += product.getPrice();
        }
        return total;
    }
}
