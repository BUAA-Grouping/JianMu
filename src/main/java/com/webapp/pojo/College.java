package com.webapp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class College implements Serializable {
    private int id;
    private String title;
    private String logo_url;
}
