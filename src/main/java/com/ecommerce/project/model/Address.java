package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 5, message = "City name must be atleast 5 characters")
    private String cityName;

    @NotBlank
    @Size(min = 5, message = "State name must be atleast 5 characters")
    private String stateName;

    @NotBlank
    @Size(min = 5, message = "Country name must be atleast 5 characters")
    private String countryName;

    @NotBlank
    @Size(min = 5, message = "PinCode must be atleast 5 characters")
    private String pincode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String cityName, String stateName, String countryName, String pincode) {
        this.street = street;
        this.buildingName = buildingName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.pincode = pincode;
    }
}
