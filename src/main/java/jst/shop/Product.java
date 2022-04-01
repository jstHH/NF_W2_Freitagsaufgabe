package jst.shop;

public class Product {
    private int productID;
    private String productName;

    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }




    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String toStringToDisplay() {
        return "\nProduktname:\t" + productName + "\nProduktnummer:\t" + productID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                '}';
    }
}
