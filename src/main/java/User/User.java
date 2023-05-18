package User;
import Product.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;

// Interface to allow polymorphism
public interface User {

    String getUsername();
    String getPassword();
    void addProductToCart(Product product);
    ArrayList<Product> getCart();
    double getTotalCost();
    void makePurchase();
    ObservableList<String> showCart();
    ObservableList<String> showPurchaseHistory();
    ObservableList<String> getProductNamesInCart();
    ObservableList<String> getProductNamesInPurchaseHistory();
    ArrayList<Product> getPurchaseHistory();



}
