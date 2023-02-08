package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {
    @Query(value = "select * from foods f where f.is_deleted = 0;", nativeQuery = true)
    List<Food> getAllFoods();




}
