package com.webapp.service.impl;

import com.webapp.dao.JobDao;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Job;
import com.webapp.service.MemberDeleteService;

import java.util.List;

public class MemberDeleteServiceImpl implements MemberDeleteService {
    JobDao jobDao = new JobDaoImpl();

    @Override
    public boolean delete(int userId, int courseId) {
        List<Job> jobList = jobDao.queryJobsByCourseId(courseId);
        for (Job j : jobList) {
            if (jobDao.queryPosterByJobId(j.getId()).getId() == userId) {
                if (!jobDao.delete(userId, j.getId())) {
                    return false;
                }
            }
        }
        return true;
    }
}
