package com.example.animalShelter.animalSanctuaries.controller;


import com.example.animalShelter.animalSanctuaries.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<Void> login(String email){
        authService.login(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
