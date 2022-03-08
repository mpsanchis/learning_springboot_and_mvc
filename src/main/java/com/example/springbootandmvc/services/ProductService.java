package com.example.springbootandmvc.services;

import com.example.springbootandmvc.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public Product findProduct(Product product) {
        var maybeProd = products.stream().filter(p -> p.getName().equals(product.getName()) && p.getPrice() == product.getPrice()).findFirst();

        return maybeProd.orElse(null);
    }

    public List<Product> findAll() {
        return products;
    }
}
