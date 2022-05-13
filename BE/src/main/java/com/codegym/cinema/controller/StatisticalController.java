package com.codegym.cinema.controller;

import com.codegym.cinema.dto.MemberStatisticalDTO;
import com.codegym.cinema.dto.MovieStatisticalDTO;
import com.codegym.cinema.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistical")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class StatisticalController {
    @Autowired
    StatisticalService statisticalService;

    @GetMapping(value = "/movie-top", params = {"limit"})
    public ResponseEntity<List<MovieStatisticalDTO>> getTopMovie(@RequestParam int limit) {
        try {
            List<MovieStatisticalDTO> movieStatisticalDTOList = statisticalService.getTopMovie(limit);
            if (movieStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movieStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/member-top", params = {"limit"})
    public ResponseEntity<List<MemberStatisticalDTO>> getTopMember(@RequestParam int limit) {
        try {
            List<MemberStatisticalDTO> memberStatisticalDTOList = statisticalService.getTopMember(limit);
            if (memberStatisticalDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(memberStatisticalDTOList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping(value = "/category-top", params = {"limit"})
//    public ResponseEntity<List<MovieCategoryStatisticalDTO>> getTopMovieCategory(@RequestParam int limit) {
//        try {
//            List<MovieCategoryStatisticalDTO> movieCategoryStatisticalDTOList = statisticalService.getTopMovieCategory(limit);
//            if (movieCategoryStatisticalDTOList.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(movieCategoryStatisticalDTOList, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping(value = "/showtime-top", params = {"limit"})
//    public ResponseEntity<List<ShowtimeStatisticalDTO>> getTopShowtime(@RequestParam int limit) {
//        try {
//            List<ShowtimeStatisticalDTO> showtimeStatisticalDTOList = statisticalService.getTopShowTime(limit);
//            if (showtimeStatisticalDTOList.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(showtimeStatisticalDTOList, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
