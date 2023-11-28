package com.seitov.gymworkload.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seitov.gymworkload.entity.ReportRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportRecordDto {

    private String trainerUsername;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Number duration;
    private ReportRecord.ActionType actionType;

}
