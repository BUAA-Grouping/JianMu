package com.webapp.service;

import com.webapp.pojo.Job;

import java.util.List;

public interface SearchJobService {
    int searchJob(String keyword, int college, int campus, List<Job> jobList);

}
