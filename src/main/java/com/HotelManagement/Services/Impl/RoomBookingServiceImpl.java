package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.Roombooking;
import com.HotelManagement.Repositeries.RoombookingRepository;
import com.HotelManagement.Services.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    RoombookingRepository roombookingRepository;
    @Override
    public String newBooking(Roombooking roombooking) {
        boolean result = entityManager.createNamedStoredProcedureQuery("addNewBooking")
                .setParameter("uname",roombooking.getName())
                .setParameter("unic",roombooking.getNic())
                .setParameter("pcount",roombooking.getPersonsCount())
                .setParameter("dcount",roombooking.getDaysCount())
                .setParameter("roomid",roombooking.getRoom_id())
                .execute();
        if (!result){
            return "Booking successfull";
        }else{
            return "something went wrong";
        }
    }

    @Override
    public List<Roombooking> viewAllBooking() {
        return roombookingRepository.getAllBooking();
    }

    @Override
    public List<Roombooking> findBookingByNic(String nic) {
        return roombookingRepository.findBookingByNic(nic);
    }

    @Override
    public String deleteBookingById(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteBookingById")
                .setParameter("bid",id).execute();
        if (!result){
            return "Booking removed";
        }else{
            return "Something wend wrong";
        }
    }

    @Override
    public List<Object[]> getRoomBookingByDate() {
        return roombookingRepository.getRoomBookingByDate();
    }
}
