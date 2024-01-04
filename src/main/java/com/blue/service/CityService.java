package com.blue.service;

import com.blue.dtos.request.CreateCityRequest;
import com.blue.dtos.response.CityResponse;
import com.blue.repository.ICityRepository;
import com.blue.repository.entities.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private ICityRepository cityRepository;
    private DistrictService districtService;

    public CityService(ICityRepository cityRepository, DistrictService districtService) {
        this.cityRepository = cityRepository;
        this.districtService = districtService;
    }

    public Boolean createCityAndDistrict(CreateCityRequest createCityRequest) {
        Optional<City> optionalCity= findByCityName(createCityRequest.getCityName());
        if (optionalCity.isEmpty()){
            City city = createCity(createCityRequest.getCityName());
            districtService.createDistrict(createCityRequest.getDistrictName(), city);
            return true;
        }
        districtService.createDistrict(createCityRequest.getDistrictName(), optionalCity.get());
        return true;
    }
    public City createCity(String cityName){
        City city = City.builder()
                .name(cityName)
                .build();
        cityRepository.save(city);
        return city;
    }
    public Optional<City> findByCityName(String cityName){
        Optional<City> optionalCity = cityRepository.findByName(cityName);
        return optionalCity;
    }

    public List<CityResponse> getAllCity() {
        List<CityResponse> cityResponseList = districtService.getAll();
        return cityResponseList;
    }
}
