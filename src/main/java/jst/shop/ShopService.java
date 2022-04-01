package jst.shop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;


    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
        orderRepo = new OrderRepo();
    }

    public Optional<Product> getProductbyID(int id) {
        try {
            return Optional.of(productRepo.getProductByID(id));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public List<Product> getProductList() {
        return productRepo.getProducts();
    }

    public void addOrder() {
        orderRepo.addOrder();
    }

    public Optional<Order> getOrder(int id) {
        try {
            return Optional.of(orderRepo.getOrder(id));
        } catch (NoSuchElementException e){
            return Optional.empty();
        }
    }

    public List<Order> getOrderList() {
        return orderRepo.getOrderList();
    }
}
