package com.webapp.pojo;

import java.io.Serializable;
import java.util.List;

public class ApplyResponse implements Serializable {
    Job job;
    List<List<Apply>> applies;
    List<List<User>> users;

    ApplyResponse() {

    }

    public ApplyResponse(Job job, List<List<Apply>> applies, List<List<User>> users) {
        this.job = job;
        this.applies = applies;
        this.users = users;
    }


    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public List<List<Apply>> getApplies() {
        return applies;
    }

    public void setApplies(List<List<Apply>> applies) {
        this.applies = applies;
    }

    public List<List<User>> getUsers() {
        return users;
    }

    public void setUsers(List<List<User>> users) {
        this.users = users;
    }
}
