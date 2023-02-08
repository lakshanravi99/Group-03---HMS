package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.User;
import com.HotelManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/findUser/{nic}")
    public List<User> findUserByID(@PathVariable String nic){
        return userService.findUserById(nic);
    }

    @PutMapping("/delete/{id}")
    public String deletUserById(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

    @PutMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String updateUser(@PathVariable Integer id,User userData){
        return  userService.updateUser(id,userData);
    }

    @PostMapping(value = "/addUser",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addNewUser(User userData){
        return userService.addUser(userData);
    }

    @GetMapping("/getCount")
    public Integer getUserCount(){
        return userService.getUserCount();
    }

    @GetMapping("/login")
    public Integer userLogin(@PathVariable String id,@PathVariable String pass){
        return userService.userLogin(id,pass);
    }
}
