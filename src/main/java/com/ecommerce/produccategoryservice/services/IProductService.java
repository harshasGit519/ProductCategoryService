package com.ecommerce.produccategoryservice.services;

import com.ecommerce.produccategoryservice.dtos.ProductDto;
import com.ecommerce.produccategoryservice.models.Product;

import java.util.List;

public interface IProductService {
    public Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateOrReplaceProduct(Long id, Product product);
}
