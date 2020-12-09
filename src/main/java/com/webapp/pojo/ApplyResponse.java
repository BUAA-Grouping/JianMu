package com.webapp.pojo;

import java.io.Serializable;
import java.util.List;

public class ApplyResponse implements Serializable {
    Job job;
    List<Apply> applies;
    List<User> users;

    ApplyResponse() {

    }

    public ApplyResponse(Job job, List<Apply> applies, List<User> users) {
        this.job = job;
        this.applies = applies;
        this.users = users;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Apply> getApplies() {
        return applies;
    }

    public void setApplies(List<Apply> applies) {
        this.applies = applies;
    }
}
