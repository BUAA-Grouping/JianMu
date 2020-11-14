package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.net.URL;

@Setter @Getter
public class User implements Serializable {
    private int id;
//    private int schoolId;
    private String name;
    private String password;
    private String emailID;

    private int collegeId;
//    private int campus;
    private String profile;

    private URL avatarUrl;

    private College college;
}
