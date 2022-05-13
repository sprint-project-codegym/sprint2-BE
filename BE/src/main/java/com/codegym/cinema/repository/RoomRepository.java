package com.codegym.cinema.repository;

import com.codegym.cinema.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT * FROM a0321i1_cinema.room where room.status_room_id = 1", nativeQuery = true)
    Page<Room> showAllRoom(Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE a0321i1_cinema.room SET room.status_room_id = 2 WHERE room.room_id = ?1", nativeQuery = true)
    void deleteAllByRoom(Integer roomId);

    @Query(value = "select * from a0321i1_cinema.room where room.room_name=?1",nativeQuery = true)
    List<Room> searchAllRoom(String roomName);

    @Query(value = "select * from a0321i1_cinema.room where (room.room_name like concat('%',?1,'%') and room.status_room_id = 1)", nativeQuery = true)
    Page<Room> findAllByRoomName(String roomName, Pageable pageable);
}
