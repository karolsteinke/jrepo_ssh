package sk.service;

import sk.model.Product;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    //using list here is simplification - it would cause race condition in a real-world app
    //use database to store the data
    private List<Product> products = new ArrayList<>();

    public void addProducts(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }
}
