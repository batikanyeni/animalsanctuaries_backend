package com.example.animalShelter.animalSanctuaries.repository;

import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISanctuarie extends JpaRepository<Sanctuarie,Integer> {
    @Override
    Optional<Sanctuarie> findById(Integer integer);

    @Override
    <S extends Sanctuarie> List<S> findAll(Example<S> example);

    @Override
    void delete(Sanctuarie entity);

    @Override
    void deleteById(Integer integer);

    Optional<Sanctuarie> findByEmail(String email);
}
