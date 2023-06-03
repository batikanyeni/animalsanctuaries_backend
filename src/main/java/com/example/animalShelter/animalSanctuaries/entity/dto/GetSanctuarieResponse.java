package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class GetSanctuarieResponse {
    private int sanctuarie_id;
    private String sanctuarie_name;
    private String tel_no;
    private String email;
    private int totalCageNum;
    private GetAddressResponse sanctuarie_address;
}
