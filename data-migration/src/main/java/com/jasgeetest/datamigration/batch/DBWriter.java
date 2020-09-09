package com.jasgeetest.datamigration.batch;

import com.jasgeetest.datamigration.model.TrackLog;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<TrackLog> {


    @Override
    public void write(List<? extends TrackLog> logs) throws Exception {


        HttpEntity<List<TrackLog>> request = new HttpEntity(logs);
        new RestTemplate().postForEntity("http://localhost:8087/consume/trackLogs", request, String.class);


        System.out.println("Data Sent for Track Logs: " + logs);

    }
}
