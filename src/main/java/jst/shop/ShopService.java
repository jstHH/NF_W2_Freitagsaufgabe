package jst.shop;

import java.util.List;
import java.util.NoSuchElementException;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;


    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
        orderRepo = new OrderRepo();
    }

    public Product getProductbyID(int id) {
        try {
            return productRepo.getProductByID(id);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Product> getProductList() {
        return productRepo.getProducts();
    }

    public void addOrder() {
        orderRepo.addOrder();
    }

    public Order getOrder(int id) {
        try {
            return orderRepo.getOrder(id);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public List<Order> getOrderList() {
        return orderRepo.getOrderList();
    }
}
