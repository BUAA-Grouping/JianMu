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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public URL getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(URL avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    private College college;
}
