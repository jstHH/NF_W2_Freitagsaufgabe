package jst.shop;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private int testID = 123;
    private String testName = "Testprodukt";

    Product testProdukt = new Product(testID, testName);

    @org.junit.jupiter.api.Test
    void getProductID() {
        assertEquals(testID, testProdukt.getProductID());
    }

    @org.junit.jupiter.api.Test
    void getProductName() {
        assertEquals(testName, testProdukt.getProductName());
    }

    @org.junit.jupiter.api.Test
    void toStringToDisplay() {
        String expected = "\nProduktname:\t" + testProdukt.getProductName() + "\nProduktnummer:\t" + testProdukt.getProductID();
        assertEquals(expected, testProdukt.toStringToDisplay());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = "Product{productID=123, productName='Testprodukt'}";
        assertEquals(expected, testProdukt.toString());
    }
}