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
    public int searchJob(String keyword, int college, int campus, List<Job> jobList, List<User> poster, List<Timestamp> expectedEndTime,int id) {
        jobList.addAll(jobDao.queryJobByConditions(keyword, college, campus, id));
        for (Job j : jobList) {
            //TODO filiter
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
    public List<ApplyResponse> getApplies(int userId) {
        List<Job> jobList = jobDao.queryJobByPoster(userId);
        List<ApplyResponse> res = new ArrayList<>();
        for (Job j : jobList) {
            List<Apply> applies = jobDao.queryApplies(j.getId());
            List<List<Apply>> app = new ArrayList<>();
            app.add(new ArrayList<Apply>());
            app.add(new ArrayList<Apply>());
            app.add(new ArrayList<Apply>());

            List<List<User>> users = new ArrayList<>();
            users.add(new ArrayList<User>());
            users.add(new ArrayList<User>());
            users.add(new ArrayList<User>());

            for (Apply apply : applies) {
                app.get(apply.getStatus() - 1).add(apply);
                users.get(apply.getStatus() - 1).add(userDao.queryInfoById(apply.getUserId()));
            }

            res.add(new ApplyResponse(j, app, users));
        }
        return res;
    }

    @Override
    public boolean reply(int userId, int jobId, int status) {
        Apply apply = new Apply();
        apply.setUserId(userId);
        apply.setJobId(jobId);
        apply.setStatus(status);
        apply.setReplyAt(new Timestamp(System.currentTimeMillis()));
        return jobDao.replyApply(apply);
    }
}
