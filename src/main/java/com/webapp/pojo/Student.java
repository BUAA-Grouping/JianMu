package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Student extends User {
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
