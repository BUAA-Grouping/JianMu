package com.webapp.service.impl;

import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.service.DeleteJobService;

public class DeleteJobServiceImpl implements DeleteJobService {
    @Override
    public int delete(int job_id, int user_id) {
        JobDaoImpl jobDao = new JobDaoImpl();
        if (jobDao.queryPostUserIdByJobId(job_id) != user_id) {
            return -1;
        }
        jobDao.delete(job_id);
        return 0;
    }
}
