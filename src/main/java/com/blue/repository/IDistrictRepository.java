package com.blue.repository;

import com.blue.repository.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findByNameAndCityId(String districtName, Long id);
}
