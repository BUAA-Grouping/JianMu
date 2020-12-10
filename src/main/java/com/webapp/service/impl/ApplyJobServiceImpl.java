package com.webapp.service.impl;

import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Apply;
import com.webapp.service.ApplyService;

import java.util.List;

public class ApplyJobServiceImpl implements ApplyService {
    JobDao jobDao = new JobDaoImpl();
    UserDao userDao = new UserDaoImpl();

    public boolean apply(Apply apply) {
        return userDao.applyJob(apply);
    }

    @Override
    public List<Apply> query(int jobId) {
        return jobDao.queryApplies(jobId);
    }
}
