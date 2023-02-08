package com.HotelManagement.Services;

import com.HotelManagement.Entities.Roombooking;

import java.util.List;

public interface RoomBookingService {

    String newBooking(Roombooking roombooking);

    List<Roombooking> viewAllBooking();

    List<Roombooking> findBookingByNic(String nic);

    String deleteBookingById(Integer id);

    List<Object[]> getRoomBookingByDate();
}
