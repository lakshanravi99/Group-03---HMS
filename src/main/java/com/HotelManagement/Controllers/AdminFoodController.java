package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;
import com.HotelManagement.Services.AdminFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/adminfood")

public class AdminFoodController {
    @Autowired
    AdminFoodService adminFoodService;

    @PostMapping(value = "/addFood",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addFood( Food foodData){
        return adminFoodService.addFood(foodData);
    }
    @PutMapping("/updatefood/{id}")
    public  String updateFood(@PathVariable Integer id,@RequestBody Food foodData){
        return adminFoodService.updateFood(id,foodData);
    }
    @DeleteMapping("/deletefood/{id}")
    public String deleteFood(@PathVariable Integer id){
        return adminFoodService.deleteFood(id);
    }
    @GetMapping("/checkorders")
    public List<Foodorder> checkOrders(){
        return adminFoodService.checkorders();
    }
    @PutMapping("/approveorder/{id}")
    public  String approveOrder(@PathVariable Integer id){
        return adminFoodService.approveOrder(id);
    }
    @PutMapping("/cancelorderadmin/{id}")
    public  String cancelOrderadmin(@PathVariable Integer id){
        return adminFoodService.cancelOrderadmin(id);
    }


    @GetMapping("/getCountAllOrders")
    public Integer getCountAllOrders(){
        return adminFoodService.getCountAllOrders();
    }

    @GetMapping("/getCountPendingOrders")
    public Integer getCountPendingOrders(){
        return adminFoodService.getCountPendingOrders();
    }

    @GetMapping("/getCountCustomerCancelOrders")
    public Integer getCountCustomerCancelOrders(){
        return adminFoodService.getCountCustomerCancelOrders();
    }

    @GetMapping("/getCountKitchenCancelOrders")
    public Integer getCountKitchenCancelOrders(){
        return adminFoodService.getCountKitchenCancelOrders();
    }

    @GetMapping("/getCountReceivedOrders")
    public Integer getCountReceivedOrders(){
        return adminFoodService.getCountReceivedOrders();
    }
}


