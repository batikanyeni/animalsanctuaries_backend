package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateSanctuarieResponse {
    private int sanctuarie_id;
    private String sanctuarie_name;
    private String tel_no;
    private String email;
    private int totalCageNum;
    private GetAddressResponse sanctruarie_address;
}
