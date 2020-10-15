package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
public class Job implements Serializable {
    private int id;
    private String title;
    private int college;
    private int campus;
    private int exceptedNumOfMember;
    private int state;
    private String profile;
    private String telephone;
    private String email;

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

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
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
}
