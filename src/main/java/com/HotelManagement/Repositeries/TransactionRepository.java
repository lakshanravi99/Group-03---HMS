package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "call hotelroyal.getAllTransactions();",nativeQuery = true)
    List<Transaction> getAllTransactions();

    @Query(value = "select hotelroyal.calculate_daily_transaction_summery();",nativeQuery = true)
    double getTodaySummery();
}