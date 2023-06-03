package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Stay;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateStayResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetStaffResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetStayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StayConverter {

    private final AnimalConverter animalConverter;
    private final SanctuarieConverter sanctuarieConverter;

    public CreateStayResponse convert(Stay from){
        return new CreateStayResponse(
                from.getStay_id(),
                animalConverter.convertGetById(from.getAnimal()),
                sanctuarieConverter.convertGetById(from.getSanctuarie()),
                from.getArrival_date()
        );

    }

    public List<GetStayResponse> convertGet(List<Stay> fromList){
        if(fromList == null)
            return null;
        return fromList.stream().map(from -> new GetStayResponse(
                from.getStay_id(),
                animalConverter.convertGetById(from.getAnimal()),
                sanctuarieConverter.convertGetById(from.getSanctuarie()),
                from.getArrival_date()
        )).collect(Collectors.toList());
    }
}
