package com.HotelManagement.Controllers;

import com.HotelManagement.Entities.LogDetail;
import com.HotelManagement.Services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping("/all")
    public List<LogDetail> getAllLogs(){
        return logService.getAllLogs();
    }

    @PutMapping("/delete/{id}")
    public String deleteLogById(@PathVariable Integer id){
        return logService.deleteLogById(id);
    }

    @GetMapping("/logCount")
    public Integer getLogCount(){
        return logService.getLogCount();
    }
}
