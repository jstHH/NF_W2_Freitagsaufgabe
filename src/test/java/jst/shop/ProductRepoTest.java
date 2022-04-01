package jst.shop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    Product produkt1 = new Product(123, "Produkt-1");
    Product produkt2 = new Product(456, "Produkt-2");
    Product produkt3 = new Product(456, "Produkt-3");
    ProductRepo testRepo;
    List<Product> testList;

    public ProductRepoTest() {
        testList = new ArrayList<>();
        testList.add(produkt1);
        testList.add(produkt2);
        testList.add(produkt3);
        testRepo = new ProductRepo(testList);
    }

    @Test
    void getProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(produkt1);
        expected.add(produkt2);
        expected.add(produkt3);

        assertEquals(expected, testRepo.getProducts());
    }

    @Test
    void getProductByID_whenIDValid_thenPassed() {
        assertEquals(produkt1, testRepo.getProductByID(123));
    }

    @Test
    void getProductByID_whenIDInvalid_thenThrowsException() {
        try {
            testRepo.getProductByID(999);
            fail();
        } catch (NoSuchElementException e) {
            assertEquals("Produkt-ID nicht vorhanden", e.getMessage());
        }
    }

    @Test
    void getProductByName_whenNameValid_thenPassed() {
        assertEquals(produkt1, testRepo.getProductByName("Produkt-1"));
    }

    @Test
    void getProductByName_whenNameInvalid_thenThrowsException() {
        try {
            testRepo.getProductByName("XXXX");
            fail();
        } catch (NoSuchElementException e) {
            assertEquals("Produkt-Name nicht vorhanden", e.getMessage());
        }
    }

    @Test
    void toStringToDisplay() {
        String expected = "\nProduktname:\tProdukt-1\nProduktnummer:\t123\n\nProduktname:\tProdukt-2\nProduktnummer:\t456\n\nProduktname:\tProdukt-3\nProduktnummer:\t456\n";
        assertEquals(expected, testRepo.toStringToDisplay());
    }

    @Test
    void testToString() {
        String expected = "ProductRepo{products=[Product{productID=123, productName='Produkt-1'}, Product{productID=456, productName='Produkt-2'}, Product{productID=456, productName='Produkt-3'}]}";
        assertEquals(expected, testRepo.toString());
    }
}