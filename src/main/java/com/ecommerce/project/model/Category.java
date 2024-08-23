package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
    @Size(min = 5, message = "Category name must contain atleast 5 characters")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
// getters and setters are important in Entities because : JPA uses them
// Hibernate is open source ORM framework : Map Java object to Relational Database

}
