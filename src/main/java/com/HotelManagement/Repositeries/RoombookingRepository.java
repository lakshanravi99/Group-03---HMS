package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.Roombooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoombookingRepository extends JpaRepository<Roombooking, Integer> {

    @Query(value = "call hotelroyal.getAllBooking();",nativeQuery = true)
    List<Roombooking> getAllBooking();
    @Query(value = "call hotelroyal.findBookinById(:nic);",nativeQuery = true)
    List<Roombooking> findBookingByNic(String nic);

    @Query(value = "SELECT * FROM hotelroyal.room_booking_by_date;",nativeQuery = true)
    List<Object[]> getRoomBookingByDate();
}