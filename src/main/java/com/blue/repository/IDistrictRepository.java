package com.blue.repository;

import com.blue.repository.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictRepository extends JpaRepository<District, Long> {
}
