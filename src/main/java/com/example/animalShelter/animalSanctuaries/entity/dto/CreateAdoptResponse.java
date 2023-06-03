package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Adopter;
import com.example.animalShelter.animalSanctuaries.entity.Animal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateAdoptResponse {
    private int adopt_id;

    private GetAdopterResponse adopter_ssn;

    private GetAnimalResponse animal;
    private LocalDate adopt_date;
}
