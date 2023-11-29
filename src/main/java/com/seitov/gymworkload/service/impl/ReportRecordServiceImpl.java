package com.seitov.gymworkload.service.impl;

import com.seitov.gymworkload.dto.ReportRecordDto;
import com.seitov.gymworkload.entity.ReportRecord;
import com.seitov.gymworkload.repository.ReportRecordRepository;
import com.seitov.gymworkload.service.ReportRecordService;
import com.seitov.gymworkload.service.ReportService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportRecordServiceImpl implements ReportRecordService {

    @Autowired
    private ReportRecordRepository repository;
    @Autowired
    private ReportService reportService;
    @Autowired
    private MapperFacade orikaMapper;

    @Override
    @Transactional
    @JmsListener(destination = "${spring.activemq.queue}")
    public void createRecord(ReportRecordDto dto) {
        ReportRecord reportRecord = orikaMapper.map(dto, ReportRecord.class);
        repository.save(reportRecord);
        reportService.updateReport(reportRecord);
    }

}
