package com.webapp.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JobsSearchResponse implements Serializable {
    private final String message = "成功找到相关项目";
    private final List<JobResponse> jobList = new ArrayList<>();

    public JobsSearchResponse(List<Job> jobList) {
        for (Job job : jobList) {
            this.jobList.add(new JobResponse(job));
        }
    }
}
