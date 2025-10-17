package com.ecommerce.produccategoryservice.services;

import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productOptional = productRepo.findById(product.getId());
        return productOptional.orElseGet(() -> productRepo.save(product));
    }

    @Override
    public Product updateOrReplaceProduct(Long id, Product product) {
        return null;
    }
}
