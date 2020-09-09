package com.jasgeetest.consumer.repository;

import com.jasgeetest.consumer.model.TrackLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackLogRepository extends JpaRepository<TrackLog, Integer> {
}
