package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.Room;
import com.HotelManagement.Repositeries.RoomRepository;
import com.HotelManagement.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public List<Room> getRoomById(Integer id) {
        return roomRepository.getRoomById(id);
    }

    @Override
    public String deleteRoomById(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteRoomById").setParameter("id",id).execute();
        if (!result){
            return "Room permently removed!";
        }else {
            return "Something went wrong!";
        }
    }

    @Override
    public String updateRoomByID(Integer id, Room roomData) {
        boolean result = entityManager.createNamedStoredProcedureQuery("updateRoomById")
                .setParameter("id",id)
                .setParameter("rSize",roomData.getSize())
                .setParameter("rCapacity",roomData.getCapacity())
                .setParameter("rBed",roomData.getBed())
                .setParameter("rServices",roomData.getServices())
                .execute();
        if (!result){
            return "Room details updated!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String addNewRoom(Room roomData) {
        boolean result = entityManager.createNamedStoredProcedureQuery("addNewRoom")
                .setParameter("rSize",roomData.getSize())
                .setParameter("rCapacity",roomData.getCapacity())
                .setParameter("rBed",roomData.getBed())
                .setParameter("rServices",roomData.getServices())
                .execute();
        if (!result){
            return "New room Added!";
        }else{
            return "Something went wrong!";
        }
    }
}
