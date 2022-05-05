package com.codegym.cinema.controller;

import com.codegym.cinema.entity.District;
import com.codegym.cinema.entity.Province;
import com.codegym.cinema.entity.Ward;
import com.codegym.cinema.service.DistrictService;
import com.codegym.cinema.service.ProvinceService;
import com.codegym.cinema.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class AddressController {
    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    WardService wardService;


    @GetMapping("/provinces")
    public ResponseEntity<List<Province>> getAllProvinceTest() {
        List<Province> provinceList1 = provinceService.findAll();
        if (provinceList1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList1, HttpStatus.OK);
    }

    @GetMapping("/districts/{provinceId}")
    public ResponseEntity<List<District>> getAllDistrictByProvinceIdTest(@PathVariable Integer provinceId) {
        List<District> districtList1 = districtService.findAllDistrictByProvinceId(provinceId);
        if (districtList1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList1, HttpStatus.OK);
    }

    @GetMapping("/wards/{districtId}")
    public ResponseEntity<List<Ward>> getWardByDistrictId(@PathVariable Integer districtId) {
        List<Ward> wardList1 = wardService.findWardByDistrictId(districtId);
        if (wardList1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wardList1, HttpStatus.OK);
    }

}
