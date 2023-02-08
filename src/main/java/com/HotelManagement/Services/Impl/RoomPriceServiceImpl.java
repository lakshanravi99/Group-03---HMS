package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.RoomPrice;
import com.HotelManagement.Repositeries.RoomPriceRepository;
import com.HotelManagement.Services.RoomPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RoomPriceServiceImpl implements RoomPriceService {

    @Autowired
    RoomPriceRepository roomPriceRepository;
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<RoomPrice> getAllRoomPrices() {
        return roomPriceRepository.getAllRoomPrices();
    }

    @Override
    public String updateRoomPriceById(Integer id, RoomPrice roomPrice) {
        boolean result = entityManager.createNamedStoredProcedureQuery("updateRoomPriceById")
                .setParameter("rid",id)
                .setParameter("rroomid",roomPrice.getRoomId())
                .setParameter("rtype",roomPrice.getType())
                .setParameter("rprice",roomPrice.getPrice())
                .execute();
        if (!result){
            return "Successsfuly update";
        }else{
            return "Something wrong";
        }
    }

    @Override
    public String deleteRoomPriceById(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteRoomPriceById")
                .setParameter("rid",id).execute();
        if (!result){
            return "delete successfull";
        }else{
            return "something went wrong";
        }
    }

    @Override
    public String addNewRoomPrice(RoomPrice roomPrice) {
        boolean result = entityManager.createNamedStoredProcedureQuery("addNewRoomPrice")
                .setParameter("rroomid",roomPrice.getRoomId())
                .setParameter("rtype",roomPrice.getType())
                .setParameter("rprice",roomPrice.getPrice()).execute();
        if (!result){
            return "New room price added";
        }else{
            return "something went wrong";
        }
    }
}
