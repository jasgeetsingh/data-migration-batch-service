package com.jasgeetest.datamigration.batch;

import com.jasgeetest.datamigration.model.TrackLog;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<TrackLog, TrackLog> {


    @Override
    public TrackLog process(TrackLog log) throws Exception {
       String empCode = log.getEmployeeCode();
        log.setEmployeeCode("EMP".concat(empCode));
        log.setTime(new Date());
        System.out.println(String.format("Processing Track Log no [%s] ", log.getId()));
        return log;
    }
}
