package com.HotelManagement.Services;

import com.HotelManagement.Entities.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransaction();

    String deleteTransactionById(Integer id);

    double getTodaySummery();
}
