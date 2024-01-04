package com.blue.service;

import com.blue.dtos.response.CityResponse;
import com.blue.repository.IDistrictRepository;
import com.blue.repository.entities.City;
import com.blue.repository.entities.District;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService {
    private IDistrictRepository districtRepository;

    public DistrictService(IDistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }


    public District createDistrict(String districtName, City city){
        District district = District.builder()
                .name(districtName)
                .city(city)
                .build();
        districtRepository.save(district);
        return district;
    }

    public List<CityResponse> getAll() {
         return districtRepository.findAll().stream().map(x -> CityResponse.builder()
                 .cityName(x.getCity().getName())
                 .districtName(x.getName())
                 .build()).collect(Collectors.toList());
    }
}
