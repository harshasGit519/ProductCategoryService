package com.ecommerce.produccategoryservice.dtos;

import com.ecommerce.produccategoryservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String categoryDescription;
}
