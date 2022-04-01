package jst.shop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Product produkt1 = new Product(123, "Testprodukt-1");
    Product produkt2 = new Product(456, "Testprodukt-2");




    @Test
    void addProduct() {
        List<Product> expected = new ArrayList<>();
        expected.add(produkt1);

        Order testOrder = new Order(1);
        testOrder.addProduct(produkt1);
        assertEquals(expected, testOrder.getProducts());
    }

    @Test
    void getOrderID() {
        Order testOrder = new Order(1);
        testOrder.addProduct(produkt1);

        assertEquals(1, testOrder.getOrderID());
    }

    @Test
    void getProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(produkt1);

        Order testOrder = new Order(1);
        testOrder.addProduct(produkt1);

        assertEquals(expected, testOrder.getProducts());
    }

    @Test
    void toStringToDisplay() {
        String expected = "Ihre Bestellung:\n\nProduktname:\tTestprodukt-1\nProduktnummer:\t123\nProduktname:\tTestprodukt-2\nProduktnummer:\t456";

        Order testOrder = new Order(1);
        testOrder.addProduct(produkt1);
        testOrder.addProduct(produkt2);

        assertEquals(expected, testOrder.toStringToDisplay());
    }
}