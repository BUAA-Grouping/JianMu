package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class College implements Serializable {
    private int id;
    private String title;
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

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
    }
}
