package com.ecommerce.produccategoryservice.dtos;

import com.ecommerce.produccategoryservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDto categoryDto;
}
