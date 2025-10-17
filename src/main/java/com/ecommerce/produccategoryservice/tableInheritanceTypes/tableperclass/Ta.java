package com.ecommerce.produccategoryservice.tableInheritanceTypes.tableperclass;

import jakarta.persistence.Entity;


@Entity(name ="tpc_ta")
public class Ta extends User {
    double hours;
}
