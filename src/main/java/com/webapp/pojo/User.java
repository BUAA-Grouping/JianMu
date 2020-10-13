package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.net.URL;

@Setter @Getter
public class User implements Serializable {
    private int id;
    private int schoolId;
    private String name;
    private String password;
    private String emailID;

    private int major;
    private int campus;
    private String profile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
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

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
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

    public User( String name, String password,String emailID,int schoolId){
        this.schoolId = schoolId;
        this.emailID = emailID;
        this.name = name;
        this.password = password;
    }
}
