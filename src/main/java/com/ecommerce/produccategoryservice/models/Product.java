package com.ecommerce.produccategoryservice.models;

import com.ecommerce.produccategoryservice.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Product extends BaseModel {

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;

    public Product(){
        this.setCreationDate(new Date());
        this.setModificationDate(new Date());
        this.setState(State.ACTIVE);
    }
}
