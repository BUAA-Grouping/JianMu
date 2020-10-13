package com.webapp.service.impl;

import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Job;
import com.webapp.service.SearchJobService;

import java.util.List;

public class SearchJobServiceImpl implements SearchJobService {

    @Override
    public int searchJob(String keyword, int college, int campus, List<Job> jobList) {
        JobDaoImpl jobDao = new JobDaoImpl();
        jobList.addAll(jobDao.queryJobByConditions(keyword, college, campus));
        if (jobList.isEmpty()) {
            return -1;
        }
        return 0;
    }
}
