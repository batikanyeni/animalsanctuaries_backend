package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Adopt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdopt extends JpaRepository<Adopt, Integer> {
}
