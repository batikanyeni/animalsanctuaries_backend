package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adopt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adopt_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Adopter adopter_ssn;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Animal animal;
    private LocalDate adopt_date;

    public Adopt(Adopter adopter_ssn, Animal animal, LocalDate adopt_date) {
        this.adopter_ssn = adopter_ssn;
        this.animal = animal;
        this.adopt_date = adopt_date;
    }
}
