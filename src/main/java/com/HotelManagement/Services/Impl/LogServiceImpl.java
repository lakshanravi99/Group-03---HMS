package com.HotelManagement.Services.Impl;

import com.HotelManagement.Entities.LogDetail;
import com.HotelManagement.Repositeries.OthersLogRepository;
import com.HotelManagement.Services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    OthersLogRepository othersLogRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public List<LogDetail> getAllLogs() {
        return othersLogRepository.getAllLogs();
    }

    @Override
    public String deleteLogById(Integer id) {
        boolean result = entityManager.createNamedStoredProcedureQuery("deleteLogById")
                .setParameter("lid",id).execute();
        if (!result){
            return "Log deleted";
        }else{
            return "something went wrong";
        }
    }

    @Override
    public Integer getLogCount() {
        return othersLogRepository.getLogsCount();
    }
}
