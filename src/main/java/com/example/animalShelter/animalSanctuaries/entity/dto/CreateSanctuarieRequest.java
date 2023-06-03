package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateSanctuarieRequest {
    private String sanctuarie_name;
    private String tel_no;
    private String email;
    private int totalCageNum;
    private String street;
    private String zip;
    private String state;
    private String city;
}
