package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.Animal;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.AdopterService;
import com.example.animalShelter.animalSanctuaries.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/animal")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<CreateAnimalResponse> create(@RequestBody CreateAnimalRequest request){
        return new ResponseEntity<>(animalService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetAnimalResponse>> getAll(){
        return new ResponseEntity<>(animalService.getAll(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<UpdateAnimalResponse> update(@RequestBody UpdateAnimalRequest request){
        return new ResponseEntity<>(animalService.update(request),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        animalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetAnimalResponse> getById(@RequestParam int id){
        return new ResponseEntity<>(animalService.findById(id),HttpStatus.OK);
    }

}
