package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Stay;
import com.example.animalShelter.animalSanctuaries.entity.Work;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.WorkConverter;
import com.example.animalShelter.animalSanctuaries.repository.IWork;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkService {

    private final IWork iWork;

    private final WorkConverter workConverter;

    private final StaffService staffService;

    private final SanctuarieService sanctuarieService;

    public CreateWorkResponse create(CreateWorkRequest request){
        Work work = new Work(
                staffService.getById(request.getStaff_id()),
                sanctuarieService.getById(request.getSanctuarie_id())
        );
        return workConverter.convert(iWork.save(work));

    }
    public List<GetWorkResponse> getAll(){
        return workConverter.convertGet(iWork.findAll());
    }
    public void delete(int id){
        iWork.deleteById(iWork.findById(id).orElseThrow(()-> new RuntimeException("work not found")).getWork_id());
    }
}

