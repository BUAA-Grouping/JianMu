package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class JobTime {
    private Timestamp startTime;
    private Timestamp expectedEndTime;
}
