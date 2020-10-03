package com.webapp.pojo;

import java.io.Serializable;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String name;
    private String password;

    private int major;
    private int grade;
    private int campus;
    private String profile;
    private URL avatar_url;

    private Timestamp update_at;
    private Timestamp create_at;
    private Timestamp last_login_at;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(java.lang.String name, java.lang.String password) {
        this.name = name;
        this.password = password;
    }
}
