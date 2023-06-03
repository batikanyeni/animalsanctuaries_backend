package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddress extends JpaRepository<Address,Integer> {
}
