package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {


    private String street;

    private String zip;

    private String state;

    private String city;
}
