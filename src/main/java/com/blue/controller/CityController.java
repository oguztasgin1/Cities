package com.blue.controller;

import com.blue.dtos.request.CreateCityRequest;
import com.blue.dtos.response.CityResponse;
import com.blue.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {
    private final CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/createcity")
    public ResponseEntity<Boolean> createCity(@RequestBody CreateCityRequest createCityRequest){
        return ResponseEntity.ok(cityService.createCityAndDistrict(createCityRequest));
    }

    @GetMapping("/getAllCity")
    @CrossOrigin("*")
    public ResponseEntity<List<CityResponse>> getAll(){
        return ResponseEntity.ok(cityService.getAllCity());
    }


}
