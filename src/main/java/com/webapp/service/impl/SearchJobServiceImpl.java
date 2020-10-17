package com.webapp.service.impl;

import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;

import java.sql.Timestamp;
import java.util.List;

public class SearchJobServiceImpl implements SearchJobService {

    @Override
    public int searchJob(String keyword, int college, int campus, List<Job> jobList, List<User> poster, List<Timestamp> expectedEndTime) {
        JobDaoImpl jobDao = new JobDaoImpl();
        jobList.addAll(jobDao.queryJobByConditions(keyword, college, campus));
        for (Job j : jobList) {
            poster.add(jobDao.queryPosterByJobId(j.getId()));
            expectedEndTime.add(jobDao.queryEndTimebyJobId(j.getId()));
        }
        if (jobList.isEmpty()) {
            return -1;
        }
        return 0;
    }
}
