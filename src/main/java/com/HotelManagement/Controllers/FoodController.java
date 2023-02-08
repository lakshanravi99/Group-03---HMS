package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.Food;
import com.HotelManagement.Entities.Foodorder;
import com.HotelManagement.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/food")

public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/all")
    public String getAll(){
        return "getAll";
    }
    @GetMapping("/getall")
    public List<Food> getAllFoods(){
        return foodService.getAllFoods();
    }

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String orderFood(Foodorder foodorderData){
        return foodService.orderFood(foodorderData);
    }

    @PutMapping("/cancelorderbyuser/{id}")
    public String cancelOrderByUser(@PathVariable Integer id){
        return foodService.cancelOrderByUser(id);
    }

    @PutMapping("/updateorder/{id}")
    public String updateOrder(@PathVariable Integer id,@RequestBody Foodorder foodBody){
        return foodService.updateOrder(id,foodBody);
    }





}
