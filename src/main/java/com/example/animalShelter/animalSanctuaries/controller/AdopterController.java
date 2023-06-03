package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.AdopterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/adopter")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdopterController {
    private final AdopterService adopterService;

    @PostMapping
    public ResponseEntity<CreateAdopterResponse> create(@RequestBody CreateAdopterRequest request){
        return new ResponseEntity<>(adopterService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetAdopterResponse>> getAll(){
        return new ResponseEntity<>(adopterService.getAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateAdopterResponse> update(@RequestBody UpdateAdopterRequest request){
        return new ResponseEntity<>(adopterService.update(request),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int ssn){
        adopterService.delete(ssn);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetAdopterResponse> getById(@RequestParam int ssn){
        return new ResponseEntity<>(adopterService.findBySsn(ssn),HttpStatus.OK);
    }
}
