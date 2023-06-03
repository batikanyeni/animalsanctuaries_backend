package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdopter extends JpaRepository<Adopter,Integer> {
}
