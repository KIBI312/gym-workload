package com.seitov.gymworkload.service;

import com.seitov.gymworkload.entity.Report;
import com.seitov.gymworkload.entity.ReportRecord;

public interface ReportService {

    void updateReport(ReportRecord reportRecord);
    Report getReport(String username);

}
