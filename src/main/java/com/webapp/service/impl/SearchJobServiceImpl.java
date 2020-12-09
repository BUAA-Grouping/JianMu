package com.webapp.service.impl;

import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Apply;
import com.webapp.pojo.ApplyResponse;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SearchJobServiceImpl implements SearchJobService {
    JobDao jobDao = new JobDaoImpl();
    UserDao userDao = new UserDaoImpl();

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

    @Override
    public Timestamp getEndTime(int jobId) {
        return jobDao.queryEndTimeByJobId(jobId);
    }

    @Override
    public List<List<ApplyResponse>> getApplies(int userId) {
        List<Job> jobList = jobDao.queryJobByPoster(userId);
        List<List<ApplyResponse>> res = new ArrayList<>();
        res.add(new ArrayList<ApplyResponse>());
        res.add(new ArrayList<ApplyResponse>());
        res.add(new ArrayList<ApplyResponse>());
        for (Job j : jobList) {
            List<Apply> applies = jobDao.queryApplies(j.getId());
            List<User> users = new ArrayList<>();
            for (Apply apply : applies) {
                users.add(userDao.queryInfoById(apply.getUserId()));
            }
            res.get(j.getState() - 1).add(new ApplyResponse(j, applies, users));
        }
        return res;
    }
}
