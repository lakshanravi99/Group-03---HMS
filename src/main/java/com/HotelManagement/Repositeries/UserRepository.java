package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "call hotelroyal.getAllUsers();", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "call hotelroyal.getUserById(:nic);", nativeQuery = true)
    List<User> findUserById(String nic);

    @Query(value = "call hotelroyal.getUserCount();",nativeQuery = true)
    Integer getUserCount();

    @Query(value = "select hotelroyal.loginfunction(:id,:pass);",nativeQuery = true)
    Integer userLogin(String id, String pass);
}