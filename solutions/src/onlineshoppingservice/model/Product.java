package onlineshoppingservice.model;

import onlineshoppingservice.enums.ProductCategory;

public class Product {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    private int id;
    private String name;

    public Product(int id, String name, int quantity, ProductCategory productCategory, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.productCategory = productCategory;
        this.price = price;
    }

    private int quantity;
    private ProductCategory productCategory;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;
}
