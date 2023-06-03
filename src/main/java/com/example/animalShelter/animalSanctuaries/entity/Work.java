package com.example.animalShelter.animalSanctuaries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int work_id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn
    private Sanctuarie sanctuarie;

    public Work(Staff staff, Sanctuarie sanctuarie) {
        this.staff = staff;
        this.sanctuarie = sanctuarie;
    }
}
