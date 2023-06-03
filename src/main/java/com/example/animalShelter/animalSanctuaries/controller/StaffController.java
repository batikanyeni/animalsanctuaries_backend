package com.example.animalShelter.animalSanctuaries.controller;

import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.service.SanctuarieService;
import com.example.animalShelter.animalSanctuaries.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/staff")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StaffController {
    private final StaffService staffService;

    @PostMapping
    public ResponseEntity<CreateStaffResponse> create(@RequestBody CreateStaffRequest request){
        return new ResponseEntity<>(staffService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GetStaffResponse>> getAll(){
        return new ResponseEntity<>(staffService.getAll(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UpdateStaffResponse> update(@RequestBody UpdateStaffRequest request){
        return new ResponseEntity<>(staffService.update(request),HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        staffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<GetStaffResponse> getById(@RequestParam int id){
        return new ResponseEntity<>(staffService.findById(id),HttpStatus.OK);
    }
}
