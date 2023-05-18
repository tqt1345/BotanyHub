package User;

import Product.*;
import com.mycompany.botanyhub.Utils;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Customer implements User, Serializable {

    private final CustomerInformation customerInformation;
    private final Cart cart;
    private final PurchaseHistory purchaseHistory;

    public Customer (String username, String password){
        this.customerInformation = new CustomerInformation(username, password);
        this.cart = new Cart();
        this.purchaseHistory = new PurchaseHistory();
    }

    
    // customerInformation Getters
    public String getUsername() {
        return this.customerInformation.getUsername();
    }

    public String getPassword() {
        return this.customerInformation.getPassword();
    }
    // customerInformation Setters
   

    // Cart getters
    @Override
    public ArrayList<Product> getCart() {
        return this.cart.getCart();
    }

    @Override
    public double getTotalCost() {
        return this.cart.getTotalCost();
    }
    // Cart setters
    @Override
    public void addProductToCart(Product product) {
        this.cart.addProductToCart(product);
    }

    @Override
    public void makePurchase() {
        Iterator<Product> iterator = this.cart.getCart().iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            this.purchaseHistory.addProduct(product);
            iterator.remove();
        }
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
    public ArrayList<Product> getPurchaseHistory() {
        return this.purchaseHistory.getPurchaseHistory();
    }

    public ObservableList<String> getProductNamesInCart() {
        return this.cart.getProductNamesInCart();
    }

    public ObservableList<String> getProductNamesInPurchaseHistory() {
        return this.purchaseHistory.getProductNamesInPurchaseHistory();
    }
    @Override
    public String toString() {
        return "Username: " + this.customerInformation.getUsername() + "\n" +
                "Password: " + this.customerInformation.getPassword() + "\n";
    }
}
