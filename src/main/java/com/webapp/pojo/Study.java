package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter @Getter
public class Study {
    private int studentId;
    private int courseId;
    private String content;
    private int status;
    private Timestamp applyAt;
    private Timestamp replyAt;
}
