package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class JobTime {
    private Timestamp startTime;
    private Timestamp expectedEndTime;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getExpectedEndTime() {
        return expectedEndTime;
    }

    public void setExpectedEndTime(Timestamp expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }
}
