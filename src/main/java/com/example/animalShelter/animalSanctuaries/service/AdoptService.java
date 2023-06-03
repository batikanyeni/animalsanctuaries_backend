package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Adopt;
import com.example.animalShelter.animalSanctuaries.entity.Animal;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdoptRequest;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdoptResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAdopterRequest;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAdoptResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.AdoptConverter;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.AdopterConverter;
import com.example.animalShelter.animalSanctuaries.repository.IAdopt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptService {
    private final IAdopt iAdopt;

    private final AdoptConverter adoptConverter;
    private final AnimalService animalService;

    private final AdopterService adopterService;

    public CreateAdoptResponse create(CreateAdoptRequest request){
        Animal adoptedAnimal = animalService.getById(request.getAnimal_id());
        adoptedAnimal.setAdopted(true);
        Adopt adopt = new Adopt(
                adopterService.getBySsn(request.getAdopter_ssn()),
                adoptedAnimal,
                request.getAdopt_date()
        );


        return adoptConverter.convert(iAdopt.save(adopt));
    }
    public List<GetAdoptResponse> getAll(){
        return adoptConverter.convertGet(iAdopt.findAll());
    }
}
