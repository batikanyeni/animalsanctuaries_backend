package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnimal extends JpaRepository<Animal,Integer> {
}
