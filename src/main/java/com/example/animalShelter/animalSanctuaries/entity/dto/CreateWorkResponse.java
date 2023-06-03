package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import com.example.animalShelter.animalSanctuaries.entity.Staff;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkResponse {

    private int work_id;

    private GetStaffResponse staff;

    private GetSanctuarieResponse sanctuarie;

}
