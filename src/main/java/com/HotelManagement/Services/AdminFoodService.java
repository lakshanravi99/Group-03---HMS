package com.HotelManagement.Services;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;

import java.util.List;

public interface AdminFoodService {

    String addFood(Food foodData);

    String updateFood(Integer id, Food foodData);

    String deleteFood(Integer id);

    List<Foodorder> checkorders();

    String approveOrder(Integer id);

    String cancelOrderadmin(Integer id);

    Integer getCountAllOrders();

    Integer getCountPendingOrders();

    Integer getCountCustomerCancelOrders();

    Integer getCountKitchenCancelOrders();

    Integer getCountReceivedOrders();
}
