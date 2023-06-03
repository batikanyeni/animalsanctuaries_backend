package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.StayService;
import com.example.animalShelter.animalSanctuaries.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/work")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkController {
    private final WorkService workService;

    @PostMapping
    public ResponseEntity<CreateWorkResponse> create(@RequestBody CreateWorkRequest request){
        return new ResponseEntity<>(workService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetWorkResponse>> getAll(){
        return new ResponseEntity<>(workService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        workService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
