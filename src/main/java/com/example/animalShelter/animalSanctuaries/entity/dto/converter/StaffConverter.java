package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Staff;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateStaffRequest;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateStaffResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetStaffResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.UpdateStaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StaffConverter {

    private final AddressConverter addressConverter;

    public CreateStaffResponse convert(Staff from){
        return new CreateStaffResponse(
                from.getStaff_id(),
                from.getS_Fname(),
                from.getS_Mname(),
                from.getS_LName(),
                from.getStaff_ssn(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getStaff_address())
        );
    }

    public UpdateStaffResponse convertUpdate(Staff from){
        return new UpdateStaffResponse(
                from.getStaff_id(),
                from.getS_Fname(),
                from.getS_Mname(),
                from.getS_LName(),
                from.getStaff_ssn(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail()
        );
    }
    public List<GetStaffResponse> convertGet(List<Staff> fromList){
        return fromList.stream().map(from -> new GetStaffResponse(
                from.getStaff_id(),
                from.getS_Fname(),
                from.getS_Mname(),
                from.getS_LName(),
                from.getStaff_ssn(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getStaff_address())

        )).collect(Collectors.toList());

    }
    public GetStaffResponse convertGetById(Staff from){
        return new GetStaffResponse(
                from.getStaff_id(),
                from.getS_Fname(),
                from.getS_Mname(),
                from.getS_LName(),
                from.getStaff_ssn(),
                from.getGender(),
                from.getTel_no(),
                from.getEmail(),
                addressConverter.convertGet(from.getStaff_address())

        );

    }
}
