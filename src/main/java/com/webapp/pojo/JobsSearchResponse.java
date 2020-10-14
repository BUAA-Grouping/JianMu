package com.webapp.pojo;

import java.io.Serializable;
import java.util.List;

public class JobsSearchResponse implements Serializable {
    private final String message = "成功找到相关项目";
    private final List<Job> jobList;

    public JobsSearchResponse(List<Job> jobList) {
        this.jobList = jobList;
    }
}
