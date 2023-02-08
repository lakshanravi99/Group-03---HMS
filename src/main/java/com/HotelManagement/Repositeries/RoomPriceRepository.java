package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomPriceRepository extends JpaRepository<RoomPrice, Integer> {

//    @Query(value = "call hotelroyal.getAllRoomPricesData();",nativeQuery = true)
//    List<RoomPrice> getAllRoomPrices();
        @Query(value = "select * from room_prices;",nativeQuery = true)
        List<RoomPrice> getAllRoomPrices();
}