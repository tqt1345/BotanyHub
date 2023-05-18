package User;

import Product.Product;
import javafx.collections.ObservableList;

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

    @Override
    public double getTotalCost() {
        return 0;
    }

    @Override
    public void makePurchase() {

    }

    @Override
    public ObservableList<String> showCart() {
        return null;
    }

    @Override
    public ObservableList<String> showPurchaseHistory() {
        return null;
    }

    @Override
    public ObservableList<String> getProductNamesInCart() {
        return null;
    }

    @Override
    public ObservableList<String> getProductNamesInPurchaseHistory() {
        return null;
    }

    @Override
    public ArrayList<Product> getPurchaseHistory() {
        return null;
    }

}

