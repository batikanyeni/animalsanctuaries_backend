package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import com.example.animalShelter.animalSanctuaries.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class GetWorkResponse {

    private int work_id;

    private GetStaffResponse staff;

    private GetSanctuarieResponse sanctuarie;
}
