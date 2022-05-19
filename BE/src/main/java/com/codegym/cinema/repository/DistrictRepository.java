package com.codegym.cinema.repository;

import com.codegym.cinema.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT district.district_id, district.district_name, district.province_id FROM district INNER JOIN province ON province.province_id = district.province_id WHERE district.province_id = ?1",
            nativeQuery = true)
    List<District> findByProvinceId(Integer provinceId);
}
