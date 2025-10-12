package com.ecommerce.produccategoryservice.controllers;

import com.ecommerce.produccategoryservice.dtos.CategoryDto;
import com.ecommerce.produccategoryservice.dtos.ProductDto;
import com.ecommerce.produccategoryservice.models.Category;
import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public IProductService iProductService;

    @GetMapping("/products/{id}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Passed ID was less than 1. Hence failed");
        }
        Product product = iProductService.getProductById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        ProductDto productDto = from(product);

        return new ResponseEntity<>(productDto, HttpStatus.OK);

    }

    @GetMapping("/products")
    List<ProductDto> getAllProducts() {
        List<Product> products = iProductService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if (!products.isEmpty()) {
            for (Product product : products) {
                ProductDto productDto = from(product);
                productDtos.add(productDto);
            }

        }
        return productDtos;
    }

    @PostMapping("/products")
    ProductDto addProduct(@RequestBody ProductDto input) {
        return input;
    }


    @PutMapping("/products/{id}")
    ResponseEntity<ProductDto> updateOrReplaceProduct(@PathVariable Long id, @RequestBody ProductDto input) {
        try {
            Product product = iProductService.updateOrReplaceProduct(id, from(input));
            ProductDto productDto = from(product);
            return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryName(product.getCategory().getCategoryName());
            categoryDto.setCategoryDescription(product.getCategory().getCategoryDescription());
            categoryDto.setId(product.getCategory().getId());
            productDto.setCategoryDto(categoryDto);
        }
        return productDto;
    }

    Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        if (productDto.getCategoryDto() != null) {
            Category category = new Category();
            category.setCategoryName(productDto.getCategoryDto().getCategoryName());
            category.setCategoryDescription(productDto.getCategoryDto().getCategoryDescription());
            category.setId(productDto.getCategoryDto().getId());
            product.setCategory(category);
        }
        return product;
    }

}
