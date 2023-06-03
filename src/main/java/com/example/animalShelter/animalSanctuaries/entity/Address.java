package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;

    private String street;

    private String zip;

    private String state;

    private String city;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "sanctruarie_address")
    private Sanctuarie sanctuarie;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "adopter_address")
    private Adopter adopter;

    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "staff_address")
    private Staff staff;

    public Address(String street, String zip, String state, String city) {
        this.street = street;
        this.zip = zip;
        this.state = state;
        this.city = city;
    }
}
