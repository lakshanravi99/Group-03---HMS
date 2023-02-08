package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.Foodorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminFoodRepository extends JpaRepository<Foodorder,Integer> {

    @Query(value = "SELECT * FROM hotelroyal.foodorder where kitchen_status='pending';",nativeQuery = true)
    List<Foodorder> checkorders();

    @Query(value = "select hotelroyal.getCountAllOrders();",nativeQuery = true)
    Integer getCountAllOrders();

    @Query(value = "select hotelroyal.getCountPendingOrders();",nativeQuery = true)
    Integer getCountPendingOrders();

    @Query(value = "select hotelroyal.getCountCustomerCancelOrders();",nativeQuery = true)
    Integer getCountCustomerCancelOrders();

    @Query(value = "select hotelroyal.getCountKitchenCancelOrders();",nativeQuery = true)
    Integer getCountKitchenCancelOrders();

    @Query(value = "select hotelroyal.getCountReceivedOrders();",nativeQuery = true)
    Integer getCountReceivedOrders();




}
