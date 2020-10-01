package com.webapp.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String nickname;

    private String profile_photo;
    private Date creat_time;
    private Date last_login;
    private String place;
    private String Department;
    private String profile;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
