package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.AdoptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/adopt")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdoptController {
    private final AdoptService adoptService;

    @PostMapping
    public ResponseEntity<CreateAdoptResponse> create(@RequestBody CreateAdoptRequest request){
        return new ResponseEntity<>(adoptService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetAdoptResponse>> getAll(){
        return new ResponseEntity<>(adoptService.getAll(),HttpStatus.OK);
    }
}
