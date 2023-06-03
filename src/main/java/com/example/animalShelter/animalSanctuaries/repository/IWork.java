package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWork extends JpaRepository<Work,Integer> {
}
