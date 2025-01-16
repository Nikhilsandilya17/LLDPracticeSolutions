package onlineshoppingservice.service;

import onlineshoppingservice.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService {


    Map<Product, Integer> productsMap;

    public List<Product> getAllProducts(){
        return new ArrayList<>(productsMap.keySet());
    }

    public void addProductToInventory(Product product){
        productsMap.put(product, productsMap.getOrDefault(product, 0)+1);
    }

    public void removeProductFromInventory(Product product, int prodQuantity){
        if(productsMap.containsKey(product)){
            int quantity = product.getQuantity() - prodQuantity;
            if(quantity>=1){
                productsMap.put(product,quantity);
            }
            else {
                productsMap.remove(product);
            }
        }
    }




}
