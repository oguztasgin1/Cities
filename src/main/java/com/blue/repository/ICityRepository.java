package com.blue.repository;

import com.blue.repository.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String cityName);
}
