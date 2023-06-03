package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.SanctuarieConverter;
import com.example.animalShelter.animalSanctuaries.repository.ISanctuarie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanctuarieService {
    private final ISanctuarie iSanctuarie;

    private final SanctuarieConverter converter;

    private final AddressService addressService;

    public CreateSanctuarieResponse create(CreateSanctuarieRequest request){
        Sanctuarie sanctuarie = new Sanctuarie(
                request.getSanctuarie_name(),
                request.getTel_no(),
                request.getEmail(),
                request.getTotalCageNum(),
                addressService.create(request.getStreet(),request.getZip(),request.getState(), request.getCity())
        );
        return converter.convert(iSanctuarie.save(sanctuarie));

    }
    public List<GetSanctuarieResponse> getAll(){
        return converter.convertGet(iSanctuarie.findAll());
    }

    public UpdateSanctuarieResponse update(UpdateSanctuarieRequest request){
        Sanctuarie byId = getById(request.getSanctuarie_id());
        byId.setSanctuarie_name(request.getSanctuarie_name());
        byId.setTel_no(request.getTel_no());
        byId.setTotalCageNum(request.getTotalCageNum());
        return converter.convertUpdate(iSanctuarie.save(byId));
    }
    public void delete(int id){
        iSanctuarie.deleteById(getById(id).getSanctuarie_id());
    }

    public GetSanctuarieResponse findById(int id){
        return converter.convertGetById(getById(id));
    }
    protected Sanctuarie getById(int id){
        return iSanctuarie.findById(id).orElseThrow(() -> new RuntimeException("Santuarie not found"));
    }

    protected Sanctuarie getByEmail(String email){
        return iSanctuarie.findByEmail(email).orElseThrow(()-> new RuntimeException("email not found"));
    }
}
