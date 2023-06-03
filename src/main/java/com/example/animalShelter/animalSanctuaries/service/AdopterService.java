package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Adopter;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.AdopterConverter;
import com.example.animalShelter.animalSanctuaries.repository.IAdopter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdopterService {
    private final IAdopter iAdopter;
    private final AdopterConverter adopterConverter;

    private final AddressService addressService;

    public CreateAdopterResponse create(CreateAdopterRequest request){
        Adopter adopter = new Adopter(
                request.getAdopter_ssn(),
                request.getA_Fname(),
                request.getA_Mname(),
                request.getA_LName(),
                request.getGender(),
                request.getTel_no(),
                request.getEmail(),
                addressService.create(request.getStreet(),request.getZip(),request.getState(), request.getCity())
        );
        return adopterConverter.convert(iAdopter.save(adopter));
    }
    public List<GetAdopterResponse> getAll(){
        return adopterConverter.convertGet(iAdopter.findAll());

    }
    public UpdateAdopterResponse update(UpdateAdopterRequest request){
        Adopter bySsn = getBySsn(request.getAdopter_ssn());
        bySsn.setGender(request.getGender());
        bySsn.setA_Fname(request.getA_Fname());
        bySsn.setA_Mname(request.getA_Mname());
        bySsn.setA_Fname(request.getA_Fname());
        bySsn.setTel_no(request.getTel_no());
        return adopterConverter.convertUpdate(iAdopter.save(bySsn));


    }

    public void delete(int ssn){
        iAdopter.deleteById(getBySsn(ssn).getAdopter_ssn());
    }

    public GetAdopterResponse findBySsn(int ssn){
        return adopterConverter.convertGetById(getBySsn(ssn));
    }
    protected Adopter getBySsn(int ssn){
        return iAdopter.findById(ssn).orElseThrow(()-> new RuntimeException("adopter not found"));
    }
}
