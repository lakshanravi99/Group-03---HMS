package com.HotelManagement.Services;

import com.HotelManagement.Entities.RoomPrice;

import java.util.List;

public interface RoomPriceService {
    List<RoomPrice> getAllRoomPrices();

    String updateRoomPriceById(Integer id, RoomPrice roomPrice);

    String deleteRoomPriceById(Integer id);

    String addNewRoomPrice(RoomPrice roomPrice);
}
