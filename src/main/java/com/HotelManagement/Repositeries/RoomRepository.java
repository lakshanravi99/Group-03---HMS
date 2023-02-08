package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select * from Room r where r.status = 0", nativeQuery = true)
    List<Room> getAllRooms();

    @Query(value = "call hotelroyal.getRoomById(:id);", nativeQuery = true)
    List<Room> getRoomById(Integer id);
}