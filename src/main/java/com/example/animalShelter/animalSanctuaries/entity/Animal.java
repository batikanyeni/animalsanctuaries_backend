package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animal_id;
    private String animal_name;
    private String species;
    private String race;
    private String pic_url;
    private LocalDate birth_date;
    private int age;
    private String gender;
    private  String color;
    private boolean adopted;
    private boolean vaccinated;
    private String health_problem;
    private int sanctuarie_id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "animal")
    private Adopt adopt;

    public Animal(String animal_name, String species, String race, String pic_url, LocalDate birth_date,
                  String gender, String color, boolean adopted, boolean vaccinated, String health_problem,
                  int sanctuarie_id) {
        this.animal_name = animal_name;
        this.species = species;
        this.race = race;
        this.pic_url = pic_url;
        this.birth_date = birth_date;
        this.gender = gender;
        this.color = color;
        this.adopted = adopted;
        this.vaccinated = vaccinated;
        this.health_problem = health_problem;
        this.sanctuarie_id = sanctuarie_id;
    }

    public int getAge() {
        return LocalDate.now().getYear()-this.birth_date.getYear();
    }
}
