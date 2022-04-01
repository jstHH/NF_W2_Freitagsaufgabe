package jst.shop;

import java.util.ArrayList;
import java.util.List;

public class CurrentProducts {
    private List<Product> currentProductList;

    public CurrentProducts() {
        currentProductList = new ArrayList<>();
        currentProductList.add(new Product(123, "Monstergrill"));
        currentProductList.add(new Product(543, "Superstaubsauger"));
        currentProductList.add(new Product(646, "Megafön"));
        currentProductList.add(new Product(877, "Ultraherd"));
        currentProductList.add(new Product(908, "Topputzeimer"));
        currentProductList.add(new Product(001, "Schickepfanne"));
    }

    public List<Product> getCurrentProductList() {
        return currentProductList;
    }
}
