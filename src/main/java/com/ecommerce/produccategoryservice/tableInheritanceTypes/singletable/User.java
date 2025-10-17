package com.ecommerce.produccategoryservice.tableInheritanceTypes.singletable;

import jakarta.persistence.*;

@Entity(name ="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    Long id;
    String email;
}