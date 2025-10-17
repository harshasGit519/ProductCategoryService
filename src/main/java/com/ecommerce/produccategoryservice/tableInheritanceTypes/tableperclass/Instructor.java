package com.ecommerce.produccategoryservice.tableInheritanceTypes.tableperclass;

import jakarta.persistence.Entity;

@Entity(name ="tpc_instructor")
public class Instructor extends User {
    String company;
}
