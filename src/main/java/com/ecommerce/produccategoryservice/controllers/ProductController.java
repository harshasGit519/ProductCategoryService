package com.ecommerce.produccategoryservice.controllers;

import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        return product;
    }

    @PostMapping("/products")
    Product addProduct(@RequestBody Product input) {
        return input;
    }

}
