package com.ecommerce.produccategoryservice.repos;

import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
