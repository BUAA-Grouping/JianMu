package com.webapp.pojo;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable {
    private int id;
    private User leader;
    private int status;
    private Date create_time;
}
