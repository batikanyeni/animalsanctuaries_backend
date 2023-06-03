package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Adopter;
import com.example.animalShelter.animalSanctuaries.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateAdoptRequest {

    private int adopter_ssn;

    private int animal_id;
    private LocalDate adopt_date;

}
