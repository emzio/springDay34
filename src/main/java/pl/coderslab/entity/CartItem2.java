package pl.coderslab.entity;

public class CartItem2 {
    private Integer quantity;
    private Product2 product;

    public CartItem2(Integer quantity, Product2 product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product2 getProduct() {
        return product;
    }

    public void setProduct(Product2 product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem2{" +
                "quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}

//    typu Integer o nazwie quantity.
//        typu Product o nazwie product.
