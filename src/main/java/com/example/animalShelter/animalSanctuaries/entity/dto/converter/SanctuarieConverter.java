package com.example.animalShelter.animalSanctuaries.entity.dto.converter;

import com.example.animalShelter.animalSanctuaries.entity.Sanctuarie;
import com.example.animalShelter.animalSanctuaries.entity.dto.CreateSanctuarieResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetAnimalResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.GetSanctuarieResponse;
import com.example.animalShelter.animalSanctuaries.entity.dto.UpdateSanctuarieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SanctuarieConverter {

    private final AddressConverter addressConverter;
    public CreateSanctuarieResponse convert(Sanctuarie from){
        return new CreateSanctuarieResponse(
                from.getSanctuarie_id(),
                from.getSanctuarie_name(),
                from.getTel_no(),
                from.getEmail(),
                from.getTotalCageNum(),
                addressConverter.convertGet(from.getSanctruarie_address())
        );

    }

    public UpdateSanctuarieResponse convertUpdate(Sanctuarie from){
        return new UpdateSanctuarieResponse(
                from.getSanctuarie_id(),
                from.getSanctuarie_name(),
                from.getTel_no(),
                from.getEmail(),
                from.getTotalCageNum()
        );
    }
    public List<GetSanctuarieResponse> convertGet(List<Sanctuarie> fromList){
      return fromList.stream().map(from -> new GetSanctuarieResponse(
              from.getSanctuarie_id(),
              from.getSanctuarie_name(),
              from.getTel_no(),
              from.getEmail(),
              from.getTotalCageNum(),
              addressConverter.convertGet(from.getSanctruarie_address())
      )).collect(Collectors.toList());
    }
    public GetSanctuarieResponse convertGetById(Sanctuarie from){
        return  new GetSanctuarieResponse(
                from.getSanctuarie_id(),
                from.getSanctuarie_name(),
                from.getTel_no(),
                from.getEmail(),
                from.getTotalCageNum(),
                addressConverter.convertGet(from.getSanctruarie_address())
        );
    }
}
