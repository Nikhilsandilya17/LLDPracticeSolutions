package onlineshoppingservice.service;

import onlineshoppingservice.enums.OrderStatus;
import onlineshoppingservice.model.Cart;
import onlineshoppingservice.model.Order;
import onlineshoppingservice.model.Product;
import onlineshoppingservice.model.User;
import onlineshoppingservice.payment.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private CartService cartService;
    private ProductService productService;
    List<Order> ordersPlaced;

    public List<Order> getOrderHistory(User user){
        return user.getOrders();
    }

    public void placeOrder(User user, Payment payment, Cart cart){
        if(!cartService.isCartEmpty()){
            int totalAmount = getCartTotalAmount(cart);
            if(payment.pay(totalAmount)){
                List<Product> productsInCart = getProductsInCart(cart);
                removeProductsFromInventory(productsInCart);
                System.out.println("Order placed successfully");
                Order order = new Order(generateOrderId(), productsInCart, OrderStatus.PLACED);
                ordersPlaced.add(order);
                markOrderForUser(user, order);
                printOrderDetails(user, order);
                cartService.emptyCart();
            }
            else {
                System.out.println("Hi "+ user.getUserName()+ " your order is "+ OrderStatus.FAILED);
            }

        }
        else{
            System.out.println("Cart is Empty !!");
        }
    }

    private void markOrderForUser(User user, Order order) {
        List<Order> orders = user.getOrders();
        orders.add(order);
    }

    private void removeProductsFromInventory(List<Product> productsInCart) {
        for(Product product: productsInCart){
            productService.removeProductFromInventory(product, product.getQuantity());
        }
    }

    private static List<Product> getProductsInCart(Cart cart) {
        return cart.getProductsInCart();
    }

    private static int getCartTotalAmount(Cart cart) {
        return cart.getTotalAmount();
    }

    private void printOrderDetails(User user, Order order){
        System.out.println("Congrats "+user.getUserName()+" your order is "+order.getOrderStatus());
        System.out.println("Order placed for products:");
        List<Product> orderItems = order.getOrderItems();
        for(Product product:orderItems){
            System.out.println(product.getName()+ " with price "+product.getPrice());
        }
        
    }

    public int generateOrderId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
    }

}
