package com.ecommerce.produccategoryservice.tableInheritanceTypes.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity(name ="st_ta")
@DiscriminatorValue(value = "TA")
public class Ta extends User {
    double hours;
}
