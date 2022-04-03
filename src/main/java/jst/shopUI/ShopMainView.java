package jst.shopUI;

import jst.shop.ShopService;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopMainView extends JFrame {
    ShopService shopService;
    JButton btnAddOrder, btnShowOrder, btnShowProducts;
    JTextField txtTypeOrderID;
    JFrame thisFrame = this;

    class ShopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();

            switch (source) {
                case "showProducts":
                    new ShopProductView(thisFrame,true, shopService);
                    break;
            }

        }
    }

    public ShopMainView(String title, ShopService shopService) throws HeadlessException {
        super(title);
        this.shopService = shopService;

        setLayout(new BorderLayout());
        add(topBar(), BorderLayout.NORTH);
        add(centerView(), BorderLayout.CENTER);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public JPanel topBar() {
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(1,2));
        panel.add(showOrderPanel());
        panel.add(addOrderShowProductsPanel());

        return panel;
    }

    public JPanel showOrderPanel(){
        JPanel panel = new JPanel();
        ShopListener listener = new ShopListener();
        txtTypeOrderID = new JTextField("Order ID");
        btnShowOrder = new JButton("Show Order");

        panel.add(txtTypeOrderID);
        panel.add(btnShowOrder);
        panel.setBorder(BorderFactory.createTitledBorder("Select Order"));

        return panel;
    }

    public JPanel addOrderShowProductsPanel() {
        JPanel panel = new JPanel();
        ShopListener listener = new ShopListener();
        btnAddOrder = new JButton("New Order");
        btnShowProducts = new JButton("Show Product List");
        btnShowProducts.addActionListener(listener);
        btnShowProducts.setActionCommand("showProducts");

        panel.add(btnAddOrder);
        panel.add(btnShowProducts);
        return panel;
    }

    public JScrollPane centerView() {
        JScrollPane pane = new JScrollPane();

        return pane;
    }
}
