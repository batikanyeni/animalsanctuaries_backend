package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.dto.GetSanctuarieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final SanctuarieService sanctuarieService;

    public void login(String email){
        sanctuarieService.getByEmail(email);
    }
}
