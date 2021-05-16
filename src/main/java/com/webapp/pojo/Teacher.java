package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Teacher extends User {
    private String teacherId;
    private String title;
}
