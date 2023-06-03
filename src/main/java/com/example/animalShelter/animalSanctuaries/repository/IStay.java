package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStay extends JpaRepository<Stay,Integer> {
}
