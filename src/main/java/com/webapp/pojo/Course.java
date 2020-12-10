package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Course {
    private int id;
    private String title;
    private int capacity;
    private String profile;
    private int college;
    private Timestamp createAt;
}
