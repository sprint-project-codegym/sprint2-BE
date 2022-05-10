package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "select * from role", nativeQuery = true)
    List<Room> findAllRoom();

    @Modifying
    @Query(value = "insert into movie_room(movie_id, room_id) values (?1,?2)", nativeQuery = true)
    void setMovieRoom(int movieId, int roomId);
}
