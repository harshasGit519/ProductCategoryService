package com.ecommerce.produccategoryservice.tableInheritanceTypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name ="st_instructor")
@DiscriminatorValue(value = "INSTRUCTOR")
public class Instructor extends User {
    String company;
}
