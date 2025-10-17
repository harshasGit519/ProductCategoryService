package com.ecommerce.produccategoryservice.repos;

import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Product save(Product product);

    Long id(Long id);

    List<Product> findProductByPriceBetween(Double priceStart, Double priceEnd);

    List<Product> findProductByIsPrime(Boolean isPrime);

    @Query("select p.description from Product p where p.id=:id")
    String findProductDescById(Long id);
}
