package com.webapp.pojo;

import java.io.Serializable;
import java.util.List;

public class ApplyResponse implements Serializable {
    Job job;
    List<Apply> applies;

    ApplyResponse(){

    }

    public ApplyResponse(Job job, List<Apply> applies) {
        this.job = job;
        this.applies = applies;
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
