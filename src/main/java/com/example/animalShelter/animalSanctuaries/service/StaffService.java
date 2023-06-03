package com.example.animalShelter.animalSanctuaries.service;

import com.example.animalShelter.animalSanctuaries.entity.Staff;
import com.example.animalShelter.animalSanctuaries.entity.dto.*;
import com.example.animalShelter.animalSanctuaries.entity.dto.converter.StaffConverter;
import com.example.animalShelter.animalSanctuaries.repository.IStaff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final IStaff iStaff;

    private final StaffConverter staffConverter;

    private final AddressService addressService;

    public CreateStaffResponse create(CreateStaffRequest request){
        Staff staff = new Staff(
                request.getS_Fname(),
                request.getS_Mname(),
                request.getS_LName(),
                request.getStaff_ssn(),
                request.getGender(),
                request.getTel_no(),
                request.getEmail(),
                addressService.create(request.getStreet(),request.getZip(),request.getState(), request.getCity())

        );
        return staffConverter.convert(iStaff.save(staff));

    }
    public List<GetStaffResponse> getAll(){
        return staffConverter.convertGet(iStaff.findAll());
    }

    public UpdateStaffResponse update(UpdateStaffRequest request){
        Staff byId = getById(request.getStaff_id());
        byId.setS_Fname(request.getS_Fname());
        byId.setS_Mname(request.getS_Mname());
        byId.setS_LName(request.getS_LName());
        byId.setStaff_ssn(request.getStaff_ssn());
        byId.setGender(request.getGender());
        byId.setTel_no(request.getTel_no());

        return staffConverter.convertUpdate(iStaff.save(byId));

    }
    public void delete(int id)
    {
        iStaff.deleteById(getById(id).getStaff_id());
    }

    public GetStaffResponse findById(int id){
        return staffConverter.convertGetById(getById(id));
    }
    protected Staff getById(int id){
        return iStaff.findById(id).orElseThrow(()-> new RuntimeException("staff not found"));
    }
}
