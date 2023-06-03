package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStaff extends JpaRepository<Staff,Integer> {
}
