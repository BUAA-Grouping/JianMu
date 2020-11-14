package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Setter @Getter
public class Job implements Serializable {
    private int id;
    private String title;
    private int collegeId;
    private int exceptedNumOfMember;
    private int state;
    private String profile;
    private String email;
    private String telephone;

    private College college;
}
