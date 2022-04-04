package jst.shopUI;

import jst.shop.ShopService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopOrderView extends JDialog {
    ShopService shopService;
    JTextArea productList;
    JButton btnAddProduct;
    JTextField txtTypeProductID;
    JTextArea areaShowOrder;
    private int orderID;

    class listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public ShopOrderView(Frame owner, boolean modal, ShopService shopService, int orderID) {
        super(owner, modal);
        this.shopService = shopService;
        this.orderID = orderID;
        setTitle("Bestellung " + orderID);

        setLayout(new BorderLayout());


    }

    public JPanel topBar() {
        JPanel panel = new JPanel();


        return panel;
    }

    public JPanel centerView() {
        JPanel panel = new JPanel();


        return panel;
    }

    public JScrollPane productList() {
        JTextArea productList = new JTextArea();
        JScrollPane pane = new JScrollPane();
        pane.setBorder(new TitledBorder("Products"));
        productList.setText(shopService.getProductListString());

        return pane;
    }
}
