package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.Roombooking;
import com.HotelManagement.Services.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/booking")
public class RoomBookingController {

    @Autowired
    RoomBookingService roomBookingService;

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String newBooking( Roombooking roombooking){
        return roomBookingService.newBooking(roombooking);
    }

    @GetMapping("/all")
    public List<Roombooking> viewAllBooking(){
        return roomBookingService.viewAllBooking();
    }

    @GetMapping("/find/{nic}")
    public List<Roombooking> findBookingByNic(@PathVariable String nic){
        return roomBookingService.findBookingByNic(nic);
    }

    @PutMapping("/delete/{id}")
    public String deleteBookingById(@PathVariable Integer id){
        return roomBookingService.deleteBookingById(id);
    }

    @GetMapping("/today")
    public List<Object[]> getRoomBookingByDate(){
        return roomBookingService.getRoomBookingByDate();
    }
}
