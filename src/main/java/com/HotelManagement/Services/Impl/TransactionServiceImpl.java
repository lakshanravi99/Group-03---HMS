package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.Transaction;
import com.HotelManagement.Repositeries.TransactionRepository;
import com.HotelManagement.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public String deleteTransactionById(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteTransactionById")
                .setParameter("tid",id).execute();
        if (!result){
            return "Transaction deleted";
        }else{
            return "Something went wrong";
        }
    }

    @Override
    public double getTodaySummery() {
        return transactionRepository.getTodaySummery();
    }
}
