package Product;

import java.util.List;

public class ProductUtils {

    public static Product getProduct (String inputtedName, List<? extends Product> products) {
        for (Product product : products) {
            if (product.getName().equals(inputtedName)) {
                return product;
            }
        }
        return null;
    }


}
