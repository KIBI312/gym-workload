package com.seitov.gymworkload.controller;

import com.seitov.gymworkload.dto.ReportRecordDto;
import com.seitov.gymworkload.entity.Report;
import com.seitov.gymworkload.service.ReportRecordService;
import com.seitov.gymworkload.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportRecordService reportRecordService;
    @Autowired
    private ReportService reportService;

    @PostMapping("/record")
    public void newReportRecord(@RequestBody ReportRecordDto dto) {
        reportRecordService.createRecord(dto);
    }

    @GetMapping("/{username}")
    public Report getReport(@PathVariable String username) {
        return reportService.getReport(username);
    }

}
