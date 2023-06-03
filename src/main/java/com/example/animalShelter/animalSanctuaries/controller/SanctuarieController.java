package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.AnimalService;
import com.example.animalShelter.animalSanctuaries.service.SanctuarieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sanctuarie")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SanctuarieController {
    private final SanctuarieService sanctuarieService;

    @PostMapping
    public ResponseEntity<CreateSanctuarieResponse> create(@RequestBody CreateSanctuarieRequest request){
        return new ResponseEntity<>(sanctuarieService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetSanctuarieResponse>> getAll(){
        return new ResponseEntity<>(sanctuarieService.getAll(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<UpdateSanctuarieResponse> update(@RequestBody UpdateSanctuarieRequest request){
        return new ResponseEntity<>(sanctuarieService.update(request),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        sanctuarieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetSanctuarieResponse> getById(@RequestParam int id){
        return new ResponseEntity<>(sanctuarieService.findById(id),HttpStatus.OK);
    }
}
