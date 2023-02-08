package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;
import com.HotelManagement.Repositeries.FoodRepository;
import com.HotelManagement.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    @PersistenceContext
    EntityManager enititymanager;

    public  List<Food> getAllFoods(){
        return foodRepository.getAllFoods();
    }

    @Override
    public String orderFood(Foodorder foodorderData) {
        boolean result = enititymanager.createNamedStoredProcedureQuery("orderFood")
                .setParameter("foodName",foodorderData.getFoodName())
                .setParameter("room",foodorderData.getRoom())
                .setParameter("qty",foodorderData.getQty())
                .execute();
        if (!result){
            return "Order Placed!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String cancelOrderByUser(Integer id) {
        boolean result = enititymanager.createNamedStoredProcedureQuery("cancelOrderByUser")
                .setParameter("id",id)
                .setParameter("customer_status","Canceled")
                .execute();
        if (!result){
            return "Room details updated!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String updateOrder(Integer id, Foodorder foodBody) {
        boolean result = enititymanager.createNamedStoredProcedureQuery("updateOrder")
                .setParameter("foodName",foodBody.getFoodName())
                .setParameter("room",foodBody.getRoom())
                .setParameter("qty",foodBody.getQty())
                .execute();
        if (!result){
            return "Room details updated!";
        }else{
            return "Something went wrong!";
        }
    }
}
