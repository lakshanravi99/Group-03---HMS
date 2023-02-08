package com.HotelManagement.Services;

import com.HotelManagement.Entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> findUserById(String nic);

    String deleteUserById(Integer id);

    String updateUser(Integer id, User userData);

    String addUser(User userData);

    Integer getUserCount();

    Integer userLogin(String id, String pass);
}
