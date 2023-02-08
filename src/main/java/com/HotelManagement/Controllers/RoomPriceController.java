package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.RoomPrice;
import com.HotelManagement.Services.RoomPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roomPrice")
public class RoomPriceController {

    @Autowired
    RoomPriceService roomPriceService;

    @GetMapping("/all")
    public List<RoomPrice> getAllRoomPrices(){
        return roomPriceService.getAllRoomPrices();
    }

    @PutMapping("/update/{id}")
    public String updateRoomPrice(@PathVariable Integer id, @RequestBody RoomPrice roomPrice){
        return roomPriceService.updateRoomPriceById(id,roomPrice);
    }

    @PutMapping("/delete/{id}")
    public String deleteRoomPriceById(@PathVariable Integer id){
        return roomPriceService.deleteRoomPriceById(id);
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addNewRoomPrice(RoomPrice roomPrice){
        return roomPriceService.addNewRoomPrice(roomPrice);
    }
}
