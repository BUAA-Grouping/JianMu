package com.webapp.pojo;

import java.io.Serializable;
import java.util.List;

public class JobsResponse implements Serializable {
    private final String message = "成功找到相关项目";
    private final List<Job> jobList;

    public JobsResponse(List<Job> jobList) {
        this.jobList = jobList;
    }
}
