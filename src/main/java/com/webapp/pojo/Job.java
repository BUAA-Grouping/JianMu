package com.webapp.pojo;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Job implements Serializable {
    private int college;
    private int campus;
    private int excepted_num_of_member;
    private int state;
    private String profile;
    private Timestamp create_at;
    private Timestamp update_at;

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

    public int getExcepted_num_of_member() {
        return excepted_num_of_member;
    }

    public void setExcepted_num_of_member(int excepted_num_of_member) {
        this.excepted_num_of_member = excepted_num_of_member;
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

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
}
