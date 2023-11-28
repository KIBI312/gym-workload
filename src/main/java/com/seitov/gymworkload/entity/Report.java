package com.seitov.gymworkload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Report {

    @Id
    private String username;
    private String firstName;
    private String lastName;
    private Boolean status;
    private Map<Year, Map<Month, Number>> summaryDuration;

    public static Report emptyReport(ReportRecord reportRecord) {
        Report newReport = new Report();
        newReport.setUsername(reportRecord.getUsername());
        newReport.setFirstName(reportRecord.getFirstName());
        newReport.setLastName(reportRecord.getLastName());
        newReport.setStatus(reportRecord.getIsActive());
        newReport.setSummaryDuration(new HashMap<>());
        return newReport;
    }

}
