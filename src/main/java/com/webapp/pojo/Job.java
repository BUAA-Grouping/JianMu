package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Job implements Serializable {
    private int id;
    private String title;
    private int college;
    private int exceptedNumOfMember;
    private int state;
    private String profile;
    private String emailId;

    private String telephone;
    private int campus;
}
