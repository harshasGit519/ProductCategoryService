package com.ecommerce.produccategoryservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    private Long id;
    private Date creationDate;
    private Date modificationDate;
    private State state;
}
