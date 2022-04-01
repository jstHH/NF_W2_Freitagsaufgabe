package jst.shop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    List<Product> products = new ArrayList<>();
    Product produkt1 = new Product(123, "Testprodukt-1");
    Product produkt2 = new Product(456, "Testprodukt-2");
    Product produkt3 = new Product(789, "Testprodukt-3");
    ProductRepo testProductRepo;
    OrderRepo testOrderRepo = new OrderRepo();
    ShopService testShop;

    public ShopServiceTest() {
        products.add(produkt1);
        products.add(produkt2);
        products.add(produkt3);
        testProductRepo = new ProductRepo(products);
        testShop = new ShopService(testProductRepo);
        testShop.addOrder();
        testShop.addOrder();
        testShop.getOrder(1).addProduct(produkt1);
    }

    @Test
    void getProduct_whenProductIDValid_thenReturnProduct() {
        assertEquals(produkt2, testShop.getProductbyID(456));
    }

    @Test
    void getProduct_whenProductIDInvalid_thenReturnNull() {
        assertNull(testShop.getProductbyID(99999));
    }

    @Test
    void getProductList() {
        assertEquals(products, testShop.getProductList());
    }

    @Test
    void addOrder() {
        ProductRepo products = new ProductRepo(this.products);
        ShopService actual = new ShopService(products);
        actual.addOrder();
        actual.addOrder();
        actual.getOrder(1).addProduct(produkt1);

        assertEquals(testShop.getOrderList(), actual.getOrderList());
    }

    @Test
    void getOrder_whenOrderIDValid_returnOrder() {
        Order expected = new Order(1);
        expected.addProduct(produkt1);

        assertEquals(expected, testShop.getOrder(1));
    }

    @Test
    void getOrder_whenOrderIDInvalid_thenReturnNull() {
        assertNull(testShop.getOrder(9999));
    }

    @Test
    void getOrderList() {
        List<Order> expected = new ArrayList<>();
        expected.add(new Order(1));
        expected.get(0).addProduct(produkt1);
        expected.add(new Order(2));

        assertEquals(expected, testShop.getOrderList());

    }
}