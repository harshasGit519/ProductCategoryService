package com.ecommerce.produccategoryservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {

    private String categoryName;
    private String categoryDescription;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 1)
    @JsonBackReference
    private List<Product> products;

    public Category() {
        this.setCreationDate(new Date());
        this.setModificationDate(new Date());
        this.setState(State.ACTIVE);
    }


}
