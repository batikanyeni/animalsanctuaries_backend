package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffResponse {
    private int staff_id;
    private String S_Fname;
    private String S_Mname;
    private String S_LName;
    private int staff_ssn;
    private String gender;
    private String tel_no;
    private String email;
}
