package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Adopter;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdopterResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAdopterResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.UpdateAdopterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdopterConverter {

    private final AddressConverter addressConverter;

    public CreateAdopterResponse convert(Adopter from){
        return new CreateAdopterResponse(
                from.getAdopter_ssn(),
                from.getA_Fname(),
                from.getA_Mname(),
                from.getA_LName(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getAdopter_address())
        );
    }
    public List<GetAdopterResponse> convertGet(List<Adopter> fromList){
        if(fromList == null){
            return null;
        }
        return fromList.stream().map(from -> new GetAdopterResponse(
                from.getAdopter_ssn(),
                from.getA_Fname(),
                from.getA_Mname(),
                from.getA_LName(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getAdopter_address())
        )).collect(Collectors.toList());
    }
    public GetAdopterResponse convertGetById(Adopter from){

        return  new GetAdopterResponse(
                from.getAdopter_ssn(),
                from.getA_Fname(),
                from.getA_Mname(),
                from.getA_LName(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getAdopter_address())
        );
    }

    public UpdateAdopterResponse convertUpdate(Adopter from){
        return new UpdateAdopterResponse(
                from.getAdopter_ssn(),
                from.getA_Fname(),
                from.getA_Mname(),
                from.getA_LName(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail()
        );
    }
}
