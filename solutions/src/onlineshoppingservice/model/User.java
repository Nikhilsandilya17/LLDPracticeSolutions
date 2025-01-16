package onlineshoppingservice.model;

import java.util.List;
import java.util.Map;

public class User {
    int userId;
    String userName;
    Map<User, Cart> userCart;

    public int getUserId() {
        return userId;
    }

    public Map<User, Cart> getUserCart() {
        return userCart;
    }

    public void setUserCart(Map<User, Cart> userCart) {
        this.userCart = userCart;
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    List<Order> orders;

    void viewProfile(){
        System.out.println("User name is: "+userName);
    }

}
