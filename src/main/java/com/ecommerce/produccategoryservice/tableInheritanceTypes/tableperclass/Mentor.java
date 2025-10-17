package com.ecommerce.produccategoryservice.tableInheritanceTypes.tableperclass;

import jakarta.persistence.Entity;

@Entity(name ="tpc_mentor")
public class Mentor extends User{
    double ratings;
}
