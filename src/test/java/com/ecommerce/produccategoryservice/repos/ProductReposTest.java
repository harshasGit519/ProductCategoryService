package com.ecommerce.produccategoryservice.repos;

import com.ecommerce.produccategoryservice.controllers.ProductController;
import com.ecommerce.produccategoryservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductReposTest {

    @Autowired
    ProductRepo  productRepo;

    @Test
    void testQueries(){
//        List<Product> allProducts = productRepo.findProductByPriceBetween(10.0, 1000.0);
//        System.out.println(allProducts.get(0).getId());

        List<Product> allProducts = productRepo.findProductByIsPrime(false);
        System.out.println(allProducts.size());


        String description = productRepo.findProductDescById(1L);
        System.out.println(description);

    }
}
