package User;

import Product.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements User, Serializable {

    private final CustomerInformation customerInformation;
    private final Cart cart;

    public Customer (String username, String password){
        this.customerInformation = new CustomerInformation(username, password);
        this.cart = new Cart();
    }

    public String getUsername() {
        return this.customerInformation.getUsername();
    }

    public String getPassword() {
        return this.customerInformation.getPassword();
    }

    @Override
    public void addProductToCart(Product product) {
        this.cart.addProductToCart(product);
    }

    @Override
    public ArrayList<Product> getCart() {
        return this.cart.getCart();
    }


    @Override
    public String toString() {
        return "Username: " + this.customerInformation.getUsername() + "\n" +
                "Password: " + this.customerInformation.getPassword() + "\n";
    }
}
