package com.ecommerce.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Entity annotation maps the class to table in database with same name, can customise name
// @Id declare primary key
@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    // delegation to JPA to generate identity
    // strategies : auto, identity, sequence, table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    private String categoryName;
// getters and setters are important in Entities because : JPA uses them
// Hibernate is open source ORM framework : Map Java object to Relational Database

}
