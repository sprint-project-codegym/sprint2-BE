package com.codegym.cinema.repository;

import com.codegym.cinema.entity.MovieRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MovieRoomRepository extends JpaRepository<MovieRoom,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into movie_room(movie_id, room_id) values (?1, ?2)", nativeQuery = true)
    void createMovieRoom(Integer movieId, Integer roomId);


}
