package pl.coderslab.entity;

import org.springframework.stereotype.Component;


public class CartIem {
    private int quantity;
    private Product product;

    public CartIem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartIem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
