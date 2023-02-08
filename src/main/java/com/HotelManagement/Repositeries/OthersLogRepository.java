package com.HotelManagement.Repositeries;

import com.HotelManagement.Entities.LogDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OthersLogRepository extends JpaRepository<LogDetail, Integer> {

    @Query(value = "select * from log_details where is_deleted = 0;",nativeQuery = true)
    List<LogDetail> getAllLogs();

    @Query(value = "select hotelroyal.getLogsCount();",nativeQuery = true)
    Integer getLogsCount();
}