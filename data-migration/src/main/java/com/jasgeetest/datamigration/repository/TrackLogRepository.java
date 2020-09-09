package com.jasgeetest.datamigration.repository;

import com.jasgeetest.datamigration.model.TrackLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackLogRepository extends JpaRepository<TrackLog, Integer> {
}
