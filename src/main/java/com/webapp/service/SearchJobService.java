package com.webapp.service;

import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.sql.Timestamp;
import java.util.List;

public interface SearchJobService {
    int searchJob(String keyword, int college, int campus, List<Job> jobList, List<User> poster, List<Timestamp> expected_end_time);

    Job getDetail(int jobId);

    User getPoster(int jobId);

    Timestamp getEndTime(int jobId);
}
