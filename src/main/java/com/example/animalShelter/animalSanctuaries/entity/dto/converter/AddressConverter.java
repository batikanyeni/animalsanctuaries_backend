package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Address;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAddressResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public CreateAddressResponse convert(Address from){
        return new CreateAddressResponse(
                from.getAddress_id(),
                from.getStreet(),
                from.getZip(),
                from.getState(),
                from.getCity()
        );
    }

    public GetAddressResponse convertGet(Address from){
        return new GetAddressResponse(
                from.getAddress_id(),
                from.getStreet(),
                from.getZip(),
                from.getState(),
                from.getCity()
        );
    }
}
