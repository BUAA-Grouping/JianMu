package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Job implements Serializable {
    private int id;
    private String title;
    private int college;
    private int exceptedNumOfMember;
    private int state;
    private String profile;
    private String emailId;
    private String telephone;
    private int campus;


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


    public void setCollege(int college) {
        this.college = college;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
