package com.seitov.gymworkload.repository;

import com.seitov.gymworkload.entity.ReportRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRecordRepository extends MongoRepository<ReportRecord, String> {

    List<ReportRecord> findByUsername(String username);

}
