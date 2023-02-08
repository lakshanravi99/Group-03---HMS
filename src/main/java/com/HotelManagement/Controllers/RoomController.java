package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.Room;
import com.HotelManagement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/all")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/find/{id}")
    public List<Room> getRoomById(@PathVariable Integer id){
        return roomService.getRoomById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteRoomById(@PathVariable Integer id){
        return roomService.deleteRoomById(id);
    }

    @PutMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String updateRoomById(@PathVariable Integer id,Room roomData){
        return roomService.updateRoomByID(id,roomData);
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addNewRoom(Room roomData){
        return roomService.addNewRoom(roomData);
    }
}
