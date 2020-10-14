package com.webapp.service.impl;

import com.webapp.dao.JobDao;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Job;
import com.webapp.service.PostJobService;

import java.sql.Timestamp;

public class PostJobServiceImpl implements PostJobService {
    private JobDao jobDao = new JobDaoImpl();

    public boolean post(int id, Job job, Timestamp expectedEndtime) {
        return jobDao.post(id, job, expectedEndtime);
    }
}
