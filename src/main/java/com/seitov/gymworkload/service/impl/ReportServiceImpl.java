package com.seitov.gymworkload.service.impl;

import com.seitov.gymworkload.entity.Report;
import com.seitov.gymworkload.entity.ReportRecord;
import com.seitov.gymworkload.repository.ReportRepository;
import com.seitov.gymworkload.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository repository;

    @Override
    public void updateReport(ReportRecord reportRecord) {
        Report report = repository.findById(reportRecord.getUsername())
                .orElse(Report.emptyReport(reportRecord));
        Year year = Year.of(reportRecord.getDate().getYear());
        Month month = reportRecord.getDate().getMonth();
        report.getSummaryDuration()
                .computeIfAbsent(year, m -> new HashMap<>())
                .merge(month, reportRecord.getDuration(), (summaryDuration, newDuration) -> {
                    Number result;
                    if(reportRecord.getActionType() == ReportRecord.ActionType.ADD) {
                        result = summaryDuration.doubleValue()+newDuration.doubleValue();
                    } else {
                        result = summaryDuration.doubleValue()-newDuration.doubleValue();
                    }
                    return result;
                });
        repository.save(report);
    }

    @Override
    public Report getReport(String username) {
        return repository.findById(username)
                .orElseThrow(() -> new IllegalArgumentException("Report for this user doesn't exist!"));
    }

}
