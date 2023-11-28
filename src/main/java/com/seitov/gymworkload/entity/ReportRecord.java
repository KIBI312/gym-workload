package com.seitov.gymworkload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ReportRecord implements Comparable<ReportRecord> {

    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private LocalDate date;
    private Number duration;
    private ActionType actionType;

    public enum ActionType {
        ADD, DELETE
    }

    @Override
    public int compareTo(ReportRecord o) {
        return getDate().compareTo(o.getDate());
    }

}
