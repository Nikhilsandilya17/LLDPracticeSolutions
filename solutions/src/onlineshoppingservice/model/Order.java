package onlineshoppingservice.model;

import onlineshoppingservice.enums.OrderStatus;

import java.util.List;

public class Order {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Product> orderItems) {
        this.orderItems = orderItems;
    }

    private OrderStatus orderStatus;

    public Order(int id, List<Product> orderItems, OrderStatus orderStatus) {
        this.id = id;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    private List<Product> orderItems;




}
