package com.ecommerce.produccategoryservice.tableInheritanceTypes.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;


@Entity(name ="jc_ta")
@PrimaryKeyJoinColumn(name ="user_id")
public class Ta extends User {
    double hours;
}
