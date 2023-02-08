package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.Transaction;
import com.HotelManagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/all")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @PutMapping("/delete/{id}")
    public String deleteTransactionById(@PathVariable Integer id){
        return transactionService.deleteTransactionById(id);
    }

    @GetMapping("/todaySummery")
    public double getTodaySummery(){
        return transactionService.getTodaySummery();
    }
}
