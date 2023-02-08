package com.HotelManagement.Services;

import com.HotelManagement.Entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();

    List<Room> getRoomById(Integer id);

    String deleteRoomById(Integer id);

    String updateRoomByID(Integer id, Room roomData);

    String addNewRoom(Room roomData);
}
