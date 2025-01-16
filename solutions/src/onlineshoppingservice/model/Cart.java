package onlineshoppingservice.model;

import java.util.List;

public class Cart {
    private int id;

    private int totalAmount;
    private List<Product> productsInCart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalAmount() {
        int totalAmount=0;
        for(Product product: productsInCart){
            totalAmount = totalAmount + product.getPrice();
        }
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

}
