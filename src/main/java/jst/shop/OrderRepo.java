package jst.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class OrderRepo {
    List<Order> orderList = new ArrayList<>();

    public OrderRepo() {
    }

    public void addOrder() {
        if (orderList.isEmpty()) {
            orderList.add(new Order(1));
        } else {
            orderList.add(new Order(orderList.get(orderList.size() - 1).getOrderID()+ 1));
        }
    }

    public Order getOrder(int id) throws NoSuchElementException {
        for (Order order: orderList) {
            if (order.getOrderID() == id) {
                return order;
            }
        }
        throw new NoSuchElementException("Keine Bestellung mit ID" + id + " vorhanden.");
    }

    public List<Order> getOrderList() {
        return orderList;
    }


    public String toStringToDisplay() {
        String result = "";
        for (Order order: orderList) {
            result += "\n\n" + order.toStringToDisplay();
        }


        return result;
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderList=" + orderList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orderList, orderRepo.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }
}
