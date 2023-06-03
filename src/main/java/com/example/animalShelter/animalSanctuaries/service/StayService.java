package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Staff;
import com.example.animalShelter.animalSanctuaries.entity.Stay;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.StayConverter;
import com.example.animalShelter.animalSanctuaries.repository.IStay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StayService {
    private final IStay iStay;

    private final StayConverter stayConverter;

    private final AnimalService animalService;

    private final SanctuarieService sanctuarieService;

    public CreateStayResponse create(CreateStayRequest request){
        Stay stay = new Stay(
                animalService.getById(request.getAnimal_id()),
                sanctuarieService.getById(request.getSanctuarie_id()),
                request.getArrival_date()
        );
        return stayConverter.convert(iStay.save(stay));

    }
    public List<GetStayResponse> getAll(){
        return stayConverter.convertGet(iStay.findAll());
    }
    public void delete(int id){
        iStay.deleteById(iStay.findById(id).orElseThrow(()-> new RuntimeException("stay not found")).getStay_id());
    }




}
