package com.seitov.gymworkload.controller;

import com.seitov.gymworkload.dto.ReportRecordDto;
import com.seitov.gymworkload.service.ReportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportRecordService reportService;


    @PostMapping
    public void returnGreet(@RequestBody ReportRecordDto dto) {
        reportService.createRecord(dto);
    }

}
