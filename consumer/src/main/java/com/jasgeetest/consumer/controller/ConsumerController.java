package com.jasgeetest.consumer.controller;

import com.jasgeetest.consumer.model.TrackLog;
import com.jasgeetest.consumer.repository.TrackLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    @Autowired
    TrackLogRepository trackLogRepository;

    @PostMapping("/trackLogs")
    public List<TrackLog> createEmployee(@RequestBody List<TrackLog> trackLogs) {
        System.out.println("size--->> "+trackLogs.size());
        trackLogs.forEach(trackLog -> {
            System.out.println("trackLog--->> "+trackLog.toString());
            trackLogRepository.save(trackLog);
        });
        return trackLogs;
    }

    @GetMapping("/trackLogs")
    public List<TrackLog> getAllEmployees() {
        return trackLogRepository.findAll();
    }
}
