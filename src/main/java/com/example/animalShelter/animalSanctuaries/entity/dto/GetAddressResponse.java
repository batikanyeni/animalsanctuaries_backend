package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponse {

    private int address_id;

    private String street;

    private String zip;

    private String state;

    private String city;
}
