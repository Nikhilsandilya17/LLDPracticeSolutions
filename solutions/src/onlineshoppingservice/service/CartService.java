package onlineshoppingservice.service;

import onlineshoppingservice.model.Product;

import java.util.Map;

public class CartService {
    private ProductService productService;
    Map<Product, Integer> cart;

    public void addProductToCart(Product product, int quantity){
        if(product.getQuantity()>quantity){
            cart.put(product, quantity);

            product.setQuantity(product.getQuantity()-quantity);
        }
        else if(product.getQuantity() == quantity){
            System.out.println("Requested quantity: "+quantity +" is same as available quantity");
            cart.put(product, product.getQuantity());
            productService.removeProductFromInventory(product, product.getQuantity());
            product.setQuantity(0);
        }
        else {
            System.out.println("As requested quantity: "+quantity+" is more than available");
            productService.removeProductFromInventory(product, product.getQuantity());
            product.setQuantity(0);
            cart.put(product, product.getQuantity());

        }
    }

    public void removeFromCart(Product product){
        if(cart.containsKey(product)){
            int quantity = cart.get(product);
            if(quantity>1){
                cart.put(product, quantity-1);
            }
            else {
                cart.remove(product);
            }
        }
        else {
            System.out.println("Product does not exist in cart");
        }
    }

    public void emptyCart(){
        cart.clear();
    }

    public boolean isCartEmpty(){
        return cart.isEmpty();
    }


}
