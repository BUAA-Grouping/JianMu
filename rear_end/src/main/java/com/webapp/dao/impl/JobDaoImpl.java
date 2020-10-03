package com.webapp.dao.impl;

import com.webapp.dao.JobDao;
import com.webapp.pojo.Job;

import java.util.List;

public class JobDaoImpl implements JobDao {
    @Override
    public void delete(int job_id) {

    }

    @Override
    public int queryPostUserIdByJobId(int job_id) {
        return 0;
    }

    @Override
    public List<Job> queryJobByConditions(String keyword, int college, int campus) {
        return null;
    }
}
