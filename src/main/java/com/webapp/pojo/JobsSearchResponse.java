package com.webapp.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JobsSearchResponse implements Serializable {
    private final String message = "成功找到相关项目";
    private final List<JobResponse> jobList = new ArrayList<>();
    private final List<User> poster;
    private final List<String> expected_end_time = new ArrayList<>();

    public JobsSearchResponse(List<Job> jobList, List<User> poster, List<Timestamp> expected_end_time) {
        for (Job job : jobList) {
            this.jobList.add(new JobResponse(job));
        }
        this.poster = poster;
        SimpleDateFormat df = new SimpleDateFormat("MM--dd-yyyy");
        for (Timestamp timestamp : expected_end_time) {
            this.expected_end_time.add(df.format(timestamp));
        }
    }
}
