package com.webapp.pojo;

import java.io.Serializable;

public class TestUser implements Serializable {
    private String name;
    private int age;
    boolean sex;

    public TestUser(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
