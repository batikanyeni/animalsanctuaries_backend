package com.example.animalShelter.animalSanctuaries.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CreateAnimalRequest {
    private String animal_name;
    private String species;
    private String race;
    private String pic_url;
    private LocalDate birth_date;
    private String gender;
    private  String color;
    private boolean adopted;
    private boolean vaccinated;
    private String health_problem;
    private int sanctuarie_id;
}
