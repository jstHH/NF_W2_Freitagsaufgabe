package jst.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductRepo {
    public List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }


    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int id) throws NoSuchElementException {
        for (Product product : products) {
            if (product.getProductID() == id) {
                return product;
            }
        }
        throw new NoSuchElementException("Produkt-ID nicht vorhanden");
    }

    public Product getProductByName(String name) throws NoSuchElementException {
        for (Product product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        throw new NoSuchElementException("Produkt-Name nicht vorhanden");
    }

    public String toStringToDisplay() {
        String result = "";
        for (Product product: products) {
            result += product.toStringToDisplay() + "\n";
        }
        return result;

    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
