package com.webapp.service;

import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.util.List;

public interface SearchJobService {
    int searchJob(String keyword, int college, int campus, List<Job> jobList, List<User> poster);

}
