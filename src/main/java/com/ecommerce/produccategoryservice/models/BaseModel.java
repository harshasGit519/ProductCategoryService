package com.ecommerce.produccategoryservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {

    private Long id;
    private Date creationDate;
    private Date modificationDate;
    private State state;
}
