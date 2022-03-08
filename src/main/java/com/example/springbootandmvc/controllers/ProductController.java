package com.example.springbootandmvc.controllers;

import com.example.springbootandmvc.models.Product;
import com.example.springbootandmvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    //no "@Autowired" needed because there is only one constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products_with_form.html";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             Model model) {
        Product p = new Product(name, price);
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products_with_form.html";
    }

    @GetMapping("/just-display-products")
    public String justDisplayProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products_static.html";
    }
}
