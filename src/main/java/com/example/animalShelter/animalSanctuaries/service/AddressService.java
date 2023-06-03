package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Address;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAddressRequest;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAddressResponse;
import com.example.animalShelter.animalSanctuaries.repository.IAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final IAddress iAddress;

    public Address create(String street,String zip , String state , String city){
        Address address = new Address(
                street,
                zip,
                state,
                city
        );
        return iAddress.save(address);

    }
}
