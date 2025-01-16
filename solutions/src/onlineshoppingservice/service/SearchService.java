package onlineshoppingservice.service;

import onlineshoppingservice.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    ProductService productService;

    public Product searchProduct(String productName){
        if(productName!=null){
            List<Product> products = getAllProducts();
            for(Product product: products){
                if(product.getName().equalsIgnoreCase(productName)){
                    System.out.println("Product "+product.getName()+ " available with quantity:"+product.getQuantity());
                    return product;
                }
            }
            System.out.println("This "+productName+" does not exist in inventory");
        }
       else {
           throw new IllegalArgumentException("Product Name cannot be null");
        }
        return null;
    }

    private List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public List<Product> searchProductsBasedOnPriceRange(int lowRange, int highRange){
        List<Product> productsInPriceRange = new ArrayList<>();
        if(lowRange>=0 && highRange>lowRange){
            List<Product> products = getAllProducts();
            for(Product product: products){
                if(product.getPrice()>=lowRange && product.getPrice()<=highRange){
                    productsInPriceRange.add(product);
                    return productsInPriceRange;
                }
            }
        }
        else {
            throw new IllegalArgumentException("Price range not valid");
        }
        return null;
    }
}
