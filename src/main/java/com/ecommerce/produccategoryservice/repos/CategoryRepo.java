package com.ecommerce.produccategoryservice.repos;

import com.ecommerce.produccategoryservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Override
    Optional<Category> findById(Long aLong);
}
