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
public class Stay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stay_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Animal animal;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Sanctuarie sanctuarie;
    private LocalDate arrival_date;

    public Stay(Animal animal, Sanctuarie sanctuarie, LocalDate arrival_date) {
        this.animal = animal;
        this.sanctuarie = sanctuarie;
        this.arrival_date = arrival_date;
    }
}
