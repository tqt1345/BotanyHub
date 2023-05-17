package User;
import Product.*;

import java.util.ArrayList;

// Interface to allow polymorphism
public interface User {

    String getUsername();
    String getPassword();
    void addProductToCart(Product product);
    ArrayList<Product> getCart();
}
