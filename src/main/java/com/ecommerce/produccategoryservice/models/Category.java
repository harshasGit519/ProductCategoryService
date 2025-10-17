package com.ecommerce.produccategoryservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {

    private String categoryName;
    private String categoryDescription;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
        this.setCreationDate(new Date());
        this.setModificationDate(new Date());
        this.setState(State.ACTIVE);
    }


}
