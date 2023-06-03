package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Animal;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateAnimalResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAdopterResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAnimalResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.UpdateAnimalResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalConverter {
    public CreateAnimalResponse convert(Animal from){
        return new CreateAnimalResponse(
                from.getAnimal_id(),
                from.getAnimal_name(),
                from.getSpecies(),
                from.getRace(),
                from.getPic_url(),
                from.getBirth_date(),
                from.getAge(),
                from.getGender(),
                from.getColor(),
                from.isAdopted(),
                from.isVaccinated(),
                from.getHealth_problem(),
                from.getSanctuarie_id()
        );

    }
    public UpdateAnimalResponse convertUpdate(Animal from){
        return new UpdateAnimalResponse(
                from.getAnimal_id(),
                from.getAnimal_name(),
                from.getSpecies(),
                from.getRace(),
                from.getPic_url(),
                from.getBirth_date(),
                from.getAge(),
                from.getGender(),
                from.getColor(),
                from.isAdopted(),
                from.isVaccinated(),
                from.getHealth_problem()
        );
    }

    public GetAnimalResponse convertGetById(Animal from){
        return new GetAnimalResponse(
                from.getAnimal_id(),
                from.getAnimal_name(),
                from.getSpecies(),
                from.getRace(),
                from.getPic_url(),
                from.getBirth_date(),
                from.getAge(),
                from.getGender(),
                from.getColor(),
                from.isAdopted(),
                from.isVaccinated(),
                from.getHealth_problem(),
                from.getSanctuarie_id()
        );
    }
    public List<GetAnimalResponse> convertGet(List<Animal> fromList){
        if(fromList == null){
            return null;
        }
        return fromList.stream().map(from -> new GetAnimalResponse(
                from.getAnimal_id(),
                from.getAnimal_name(),
                from.getSpecies(),
                from.getRace(),
                from.getPic_url(),
                from.getBirth_date(),
                from.getAge(),
                from.getGender(),
                from.getColor(),
                from.isAdopted(),
                from.isVaccinated(),
                from.getHealth_problem(),
                from.getSanctuarie_id()
        )).collect(Collectors.toList());

    }

}
