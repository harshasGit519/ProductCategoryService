package com.ecommerce.produccategoryservice.models;

import com.ecommerce.produccategoryservice.dtos.ProductDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Product extends BaseModel {

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    // if new category, this cascade.All will create a new one
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    boolean isPrime;

    public Product(){
        this.setCreationDate(new Date());
        this.setModificationDate(new Date());
        this.setState(State.ACTIVE);
    }
}
