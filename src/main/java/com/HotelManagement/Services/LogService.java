package com.HotelManagement.Services;

import com.HotelManagement.Entities.LogDetail;

import java.util.List;

public interface LogService {
    List<LogDetail> getAllLogs();

    String deleteLogById(Integer id);

    Integer getLogCount();
}
