package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Integer> {

    @Transactional
    @Modifying
    @Query(value = "SELECT ward.ward_id, ward.ward_name, ward.district_id FROM ward INNER JOIN district ON ward.district_id = district.district_id WHERE ward.district_id = ?1",
            nativeQuery = true)
    List<Ward> findByDistrictId(int districtId);
}
