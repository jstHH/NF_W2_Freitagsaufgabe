package jst.shop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    Product produkt1 = new Product(123, "Produkt-1");
    Product produkt2 = new Product(456, "Produkt-2");
    Product produkt3 = new Product(789, "Produkt-3");


    @Test
    void addOrder() {
        OrderRepo testRepo = new OrderRepo();
        testRepo.addOrder();
        Order expected = new Order(1);

        assertEquals(expected, testRepo.getOrder(1));
    }

    @Test
    void getOrder() {
        OrderRepo testRepo = new OrderRepo();
        testRepo.addOrder();
        Order expected = new Order(1);

        assertEquals(expected, testRepo.getOrder(1));

    }

    @Test
    void getOrderList() {
        List<Order> expected = new ArrayList<>();
        expected.add(new Order(1));
        expected.add(new Order(2));

        OrderRepo testRepo = new OrderRepo();
        testRepo.addOrder();
        testRepo.addOrder();

        assertEquals(expected, testRepo.getOrderList());
    }

    @Test
    void toStringToDisplay() {
        String  expected = """


                Bestellung 1:

                Produktname:\tProdukt-1
                Produktnummer:\t123

                Bestellung 2:

                Produktname:\tProdukt-2
                Produktnummer:\t456
                Produktname:\tProdukt-3
                Produktnummer:\t789""";

        OrderRepo testRepo = new OrderRepo();
        testRepo.addOrder();
        testRepo.addOrder();
        testRepo.getOrder(1).addProduct(produkt1);
        testRepo.getOrder(2).addProduct(produkt2);
        testRepo.getOrder(2).addProduct(produkt3);

        assertEquals(expected, testRepo.toStringToDisplay());
    }
}