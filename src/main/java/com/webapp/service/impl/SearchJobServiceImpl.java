package com.webapp.service.impl;

import com.webapp.dao.JobDao;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;

import java.sql.Timestamp;
import java.util.List;

public class SearchJobServiceImpl implements SearchJobService {
    JobDao jobDao = new JobDaoImpl();

    @Override
    public int searchJob(String keyword, int college, int campus, List<Job> jobList, List<User> poster, List<Timestamp> expectedEndTime) {
        jobList.addAll(jobDao.queryJobByConditions(keyword, college, campus));
        for (Job j : jobList) {
            poster.add(jobDao.queryPosterByJobId(j.getId()));
            expectedEndTime.add(jobDao.queryEndTimeByJobId(j.getId()));
        }
        if (jobList.isEmpty()) {
            return -1;
        }
        return 0;
    }

    @Override
    public Job getDetail(int jobId) {
        return jobDao.queryInfoByJobId(jobId);
    }

    @Override
    public User getPoster(int jobId) {
        return jobDao.queryPosterByJobId(jobId);
    }
}
