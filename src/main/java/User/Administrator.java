package User;

import Product.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrator implements User, Serializable {

    private final AdminInformation adminInformation;
    public Administrator (String username, String password){
        this.adminInformation = new AdminInformation(username, password);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void addProductToCart(Product product) {

    }

    @Override
    public ArrayList<Product> getCart() {
        return null;
    }

}

