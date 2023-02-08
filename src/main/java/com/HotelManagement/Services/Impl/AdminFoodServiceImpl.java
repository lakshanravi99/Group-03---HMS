package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;
import com.HotelManagement.Repositeries.AdminFoodRepository;
import com.HotelManagement.Services.AdminFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AdminFoodServiceImpl  implements AdminFoodService{
    @Autowired
    AdminFoodRepository adminFoodRepository;

    @Autowired
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public String addFood(Food foodData) {
        boolean result = entityManager.createNamedStoredProcedureQuery("addFood")
//                .setParameter("Availability",foodData.getAvailability())
                .setParameter("foodName",foodData.getFoodname())
                .setParameter("price",foodData.getPrice())
                .execute();
        if (!result){
            return "Added Food";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String updateFood(Integer id, Food foodData) {
        boolean result = entityManager.createNamedStoredProcedureQuery("updateFood")
                .setParameter("id",id)
                .setParameter("Availability",foodData.getAvailability())
                .setParameter("foodName",foodData.getFoodname())
                .setParameter("price",foodData.getPrice())
                .execute();
        if (!result){
            return "Food details updated!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String deleteFood(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteFood").setParameter("id",id).execute();
        if (!result){
            return "Food permently removed!";
        }else {
            return "Something went wrong!";
        }
    }

    @Override
    public List<Foodorder> checkorders() {
        return adminFoodRepository.checkorders();

    }

    @Override
    public String approveOrder(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("approveOrder")
                .setParameter("id",id)
                .execute();
        if (!result){
            return "Food order confirmed!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public String cancelOrderadmin(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("cancelOrderadmin")
                .setParameter("id",id)
                .execute();
        if (!result){
            return "Cancelde Order!";
        }else{
            return "Something went wrong!";
        }
    }

    @Override
    public Integer getCountAllOrders() {
        return adminFoodRepository.getCountAllOrders();
    }

    @Override
    public Integer getCountPendingOrders() {
        return adminFoodRepository.getCountPendingOrders();
    }

    @Override
    public Integer getCountCustomerCancelOrders() {
        return adminFoodRepository.getCountCustomerCancelOrders();
    }

    @Override
    public Integer getCountKitchenCancelOrders() {
        return adminFoodRepository.getCountKitchenCancelOrders();
    }

    @Override
    public Integer getCountReceivedOrders() {
        return adminFoodRepository.getCountReceivedOrders();
    }
}
