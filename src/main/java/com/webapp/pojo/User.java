package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

@Setter @Getter
public class User implements Serializable {
    private int id;
    private int schoolId;
    private String name;
    private String password;
    private String email;

    private int major;
    private int campus;
    private String profile;
    private URL avatarUrl;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int schoolId, String name, String password) {
        this.schoolId = schoolId;
        this.name = name;
        this.password = password;
    }
}
