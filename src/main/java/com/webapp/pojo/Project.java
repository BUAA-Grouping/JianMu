package com.webapp.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private int id;
    private int require_num;
    private Date time;
    private int status;
    private String department;
    private String place;
}
