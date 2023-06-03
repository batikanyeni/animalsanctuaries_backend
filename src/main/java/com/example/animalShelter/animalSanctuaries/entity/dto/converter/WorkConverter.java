package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Work;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateWorkResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetWorkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WorkConverter {


    private final SanctuarieConverter sanctuarieConverter;

    private final StaffConverter staffConverter;

    public CreateWorkResponse convert(Work from){
        return new CreateWorkResponse(
                from.getWork_id(),
                staffConverter.convertGetById(from.getStaff()),
                sanctuarieConverter.convertGetById(from.getSanctuarie())
        );
    }

    public List<GetWorkResponse> convertGet(List<Work> fromList){
        if (fromList == null){
            return null;
        }
        return fromList.stream().map(from -> new GetWorkResponse(
                from.getWork_id(),
                staffConverter.convertGetById(from.getStaff()),
                sanctuarieConverter.convertGetById(from.getSanctuarie())
        )).collect(Collectors.toList());
    }
}
