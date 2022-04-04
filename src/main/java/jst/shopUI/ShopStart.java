package jst.shopUI;

import jst.shop.CurrentProducts;
import jst.shop.ProductRepo;
import jst.shop.ShopService;

public class ShopStart {
    public static void main(String[] args) {
        new ShopMainView("Toller Shop", new ShopService(new ProductRepo(CurrentProducts.getCurrentProductList())));
    }
}
