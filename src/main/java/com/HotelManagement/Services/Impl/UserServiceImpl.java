package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.User;
import com.HotelManagement.Repositeries.UserRepository;
import com.HotelManagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> findUserById(String nic) {
        return userRepository.findUserById(nic);
    }

    @Override
    public String deleteUserById(Integer id) {
        boolean status = entityManager.createNamedStoredProcedureQuery("deleteUserById").setParameter("id",id).execute();
        if (!status){
            return "User deleted";
        }else{
            return "Something went wrong";
        }
    }

    @Override
    public String updateUser(Integer id, User userData) {
        boolean status = entityManager.createNamedStoredProcedureQuery("updateUser").setParameter("id",id).setParameter("uusername",userData.getUsername()).setParameter("utype",userData.getUserType()).setParameter("uName",userData.getName()).setParameter("ugender",userData.getGender()).setParameter("ucountry",userData.getCountry()).setParameter("ureigion",userData.getReigion()).setParameter("upassword",userData.getPassword()).execute();
        if (!status){
            return "User upadted";
        }else{
            return "Something went wrong";
        }
    }

    @Override
    public String addUser(User userData) {
        boolean status = entityManager.createNamedStoredProcedureQuery("addNewUser").setParameter("uusername",userData.getUsername()).setParameter("utype",userData.getUserType()).setParameter("uName",userData.getName()).setParameter("ugender",userData.getGender()).setParameter("unic",userData.getNic()).setParameter("upassport",userData.getPassport()).setParameter("ucountry",userData.getCountry()).setParameter("ureigion",userData.getReigion()).setParameter("upassword",userData.getPassword()).execute();
        if (!status){
            return "User registered!";
        }else{
            return "Something went wrong";
        }
    }

    @Override
    public Integer getUserCount() {
        return userRepository.getUserCount();
    }

    @Override
    public Integer userLogin(String id, String pass) {
        return userRepository.userLogin(id,pass);
    }
}
