package com.codegym.cinema.repository;

import com.codegym.cinema.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {
    @Query(value = "select d from District d join Province p on p.provinceId = d.province.provinceId where p.provinceId =?1")
    List<District> findAllDistrictByProvinceId(Integer provinceId);
}