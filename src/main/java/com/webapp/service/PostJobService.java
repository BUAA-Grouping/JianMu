package com.webapp.service;

import com.webapp.pojo.Job;

import java.sql.Timestamp;

public interface PostJobService {
    boolean post(int id, Job job, Timestamp expectedEndTime);
}
