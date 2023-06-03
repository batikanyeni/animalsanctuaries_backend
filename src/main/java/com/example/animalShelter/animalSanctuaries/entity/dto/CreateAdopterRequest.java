package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class CreateAdopterRequest {
    private int adopter_ssn;
    private String a_Fname;
    private String a_Mname;
    private String a_LName;
    private String gender;
    private String tel_no;
    private String email;
    private String street;
    private String zip;
    private String state;
    private String city;

}
