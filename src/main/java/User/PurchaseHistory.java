package User;

import java.io.Serializable;
import java.util.ArrayList;
import Product.*;
import javafx.collections.ObservableList;

public class PurchaseHistory implements Serializable {
    ArrayList<Product> purchaseHistory;

    public PurchaseHistory() {
        this.purchaseHistory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.purchaseHistory.add(product);
    }

    public ArrayList<Product> getPurchaseHistory() {
        return this.purchaseHistory;
    }

    public void clearPurchaseHistory() {
        this.purchaseHistory.clear();
    }

    public ObservableList<String> getProductNamesInPurchaseHistory() {
        return ProductUtils.getProductNamesAsObservableList(this.purchaseHistory);
    }
}
