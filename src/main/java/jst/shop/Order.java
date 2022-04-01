package jst.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int orderID;
    private List<Product> products = new ArrayList<>();

    public Order(int orderID) {
        this.orderID = orderID;
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public int getOrderID() {
        return orderID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String toStringToDisplay() {
        String result = "Bestellung " + orderID + ":\n";
        for (Product product : products) {
            result += product.toStringToDisplay();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, products);
    }
}
