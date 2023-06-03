package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Animal;
import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.AnimalConverter;
import com.example.animalShelter.animalSanctuaries.repository.IAnimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final IAnimal iAnimal;

    private final AnimalConverter animalConverter;

    private final SanctuarieService sanctuarieService;



    public CreateAnimalResponse create(CreateAnimalRequest request){
        int sanctuarie_id = request.getSanctuarie_id();
        Animal animal = new Animal(
                request.getAnimal_name(),
                request.getSpecies(),
                request.getRace(),
                request.getPic_url(),
                request.getBirth_date(),
                request.getGender(),
                request.getColor(),
                request.isAdopted(),
                request.isVaccinated(),
                request.getHealth_problem(),
                sanctuarie_id
        );
        Sanctuarie byId = sanctuarieService.getById(sanctuarie_id);
        if (byId.getTotalCageNum() > 0){
            byId.setTotalCageNum(byId.getTotalCageNum() -1);
        }else{
            throw  new RuntimeException("cage not found");
        }

        return animalConverter.convert(iAnimal.save(animal));
    }

    public List<GetAnimalResponse> getAll(){
        return animalConverter.convertGet(iAnimal.findAll());
    }

    public UpdateAnimalResponse update(UpdateAnimalRequest request){
        Animal byId = getById(request.getAnimal_id());
        byId.setAnimal_name(request.getAnimal_name());
        byId.setBirth_date(request.getBirth_date());
        byId.setColor(request.getColor());
        byId.setGender(request.getGender());
        byId.setPic_url(request.getPic_url());
        byId.setHealth_problem(request.getHealth_problem());
        byId.setRace(request.getRace());
        byId.setSpecies(request.getSpecies());
        byId.setVaccinated(request.isVaccinated());
        byId.setAdopted(request.isAdopted());
        return animalConverter.convertUpdate(iAnimal.save(byId));
    }

    public void delete(int id){
        iAnimal.deleteById(getById(id).getAnimal_id());
    }

    public GetAnimalResponse findById(int id){
        return animalConverter.convertGetById(getById(id));
    }
    protected Animal getById(int id){
        return iAnimal.findById(id).orElseThrow(() -> new RuntimeException("animal not found") );
    };
}
