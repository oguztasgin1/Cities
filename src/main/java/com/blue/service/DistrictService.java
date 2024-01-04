package com.blue.service;

import com.blue.dtos.response.CityResponse;
import com.blue.repository.IDistrictRepository;
import com.blue.repository.entities.City;
import com.blue.repository.entities.District;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DistrictService {
    private IDistrictRepository districtRepository;

    public DistrictService(IDistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    public Boolean createDistrict(String districtName, City city){
        Optional<District> districtOptional = districtRepository.findByNameAndCityId(districtName, city.getId());
        if (districtOptional.isEmpty()){
            District district = District.builder()
                    .name(districtName)
                    .city(city)
                    .build();
            districtRepository.save(district);
            return true;
        }
        return false;
    }

    public List<CityResponse> getAll() {
         return districtRepository.findAll().stream().map(x -> CityResponse.builder()
                 .cityName(x.getCity().getName())
                 .districtName(x.getName())
                 .build()).collect(Collectors.toList());
    }
}
