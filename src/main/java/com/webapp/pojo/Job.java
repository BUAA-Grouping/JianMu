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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getExceptedNumOfMember() {
        return exceptedNumOfMember;
    }

    public void setExceptedNumOfMember(int exceptedNumOfMember) {
        this.exceptedNumOfMember = exceptedNumOfMember;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
