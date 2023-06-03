package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.StaffService;
import com.example.animalShelter.animalSanctuaries.service.StayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stay")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StayController {
    private final StayService stayService;

    @PostMapping
    public ResponseEntity<CreateStayResponse> create(@RequestBody CreateStayRequest request){
        return new ResponseEntity<>(stayService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetStayResponse>> getAll(){
        return new ResponseEntity<>(stayService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        stayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
