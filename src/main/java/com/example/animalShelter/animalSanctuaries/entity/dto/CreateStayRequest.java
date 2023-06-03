package com.example.animalShelter.animalSanctuaries.entity.dto;

import com.example.animalShelter.animalSanctuaries.entity.Animal;
import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateStayRequest {

    private int animal_id;

    private int sanctuarie_id;
    private LocalDate arrival_date;
}
