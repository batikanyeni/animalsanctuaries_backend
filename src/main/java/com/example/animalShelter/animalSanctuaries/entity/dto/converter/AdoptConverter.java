package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Adopt;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdoptResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdopterResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAdoptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdoptConverter {

    private final AdopterConverter adopterConverter;

    private final AnimalConverter animalConverter;
    public CreateAdoptResponse convert(Adopt from){
        return new CreateAdoptResponse(
                from.getAdopt_id(),
                adopterConverter.convertGetById(from.getAdopter_ssn()),
                animalConverter.convertGetById(from.getAnimal()),
                from.getAdopt_date()
        );
    }
    public List<GetAdoptResponse> convertGet(List<Adopt> fromList){
        if(fromList == null){
            return null;
        }
        return fromList.stream().map(from -> new GetAdoptResponse(
                from.getAdopt_id(),
                adopterConverter.convertGetById(from.getAdopter_ssn()),
                animalConverter.convertGetById(from.getAnimal()),
                from.getAdopt_date()
        )).collect(Collectors.toList());
    }
}
