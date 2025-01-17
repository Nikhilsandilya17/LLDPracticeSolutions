package onlineshoppingservice;

import onlineshoppingservice.enums.ProductCategory;
import onlineshoppingservice.model.Cart;
import onlineshoppingservice.model.Product;
import onlineshoppingservice.model.User;
import onlineshoppingservice.payment.Payment;
import onlineshoppingservice.payment.impl.CreditCardService;
import onlineshoppingservice.service.CartService;
import onlineshoppingservice.service.ProductService;
import onlineshoppingservice.service.SearchService;
import onlineshoppingservice.service.UserService;

import java.util.List;

public class OnlineShoppingServiceDemo {

    public static void run(){
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        SearchService searchService = new SearchService();
        UserService userService = new UserService();

        //Make users
        User user1 = new User(1, "Nikhil");
        User user2 = new User(2, "Anand");

        //Make products
        Product product1 = new Product(1, "BAT", 3, ProductCategory.SPORTS, 100);
        Product product2 = new Product(2, "JEANS", 4, ProductCategory.CLOTHES, 500);
        Product product3 = new Product(3, "MOBILE", 10, ProductCategory.ELECTRONICS, 10000);
        Product product4 = new Product(4 ,"TOY", 6, ProductCategory.KIDS, 200);

        //Add products to inventory
        productService.addProductToInventory(product1);
        productService.addProductToInventory(product2);
        productService.addProductToInventory(product3);
        productService.addProductToInventory(product4);

        //Print Inventory
        List<Product> productList = productService.getAllProducts();
        for(Product product: productList){
            System.out.println("Product Name: "+product.getName()+" with quantity: "+product.getQuantity()+" and price: "+product.getPrice());
        }

        //Search
        List<Product> products = searchService.searchProductsBasedOnPriceRange(100,500);
        Product product = searchService.searchProduct("BAT");

        //Make cart
        Cart cart = new Cart();
        cartService.addProductToCart(product1, 1);
        cartService.addProductToCart(product2,1);
        cartService.addProductToCart(product3,1);

        //Create payment
        Payment creditCardPayment = new CreditCardService("Nikhil", "123", "123", "123");

        //Place order
        userService.placeOrder(user1, creditCardPayment, cart);









    }



}
