package com.ecommerce.produccategoryservice.tableInheritanceTypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name ="st_mentor")
@DiscriminatorValue(value = "MENTOR")
public class Mentor extends User {
    double ratings;
}
