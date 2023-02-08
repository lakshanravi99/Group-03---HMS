package com.HotelManagement.Services;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;

import java.util.List;

public interface FoodService {

    List<Food> getAllFoods();


    String orderFood(Foodorder foodorderData);

    String cancelOrderByUser(Integer id);


    String updateOrder(Integer id, Foodorder foodBody);
}
