package jst.shopUI;

import jst.shop.Product;
import jst.shop.ShopService;

import javax.swing.*;
import java.awt.*;

public class ShopProductView extends JDialog {
    JLabel areaProductList;
    ShopService shopService;

    public ShopProductView(Frame owner, boolean modal, ShopService shopService) {
        super(owner, modal);
        this.shopService = shopService;
        setTitle("Products");

        add(displayProducts());

        pack();
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    JPanel displayProducts () {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(0,1));
        for (Product product : shopService.getProductList()) {
            pane.add(new JLabel("Produkt: " + product.getProductName()));
            pane.add(new JLabel("Produktnummer :" + product.getProductID()));
            pane.add(new JLabel());
        }
        return pane;
    }
}
