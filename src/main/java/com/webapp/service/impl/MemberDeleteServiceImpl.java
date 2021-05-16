package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Apply;
import com.webapp.pojo.Job;
import com.webapp.service.MemberDeleteService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class MemberDeleteServiceImpl implements MemberDeleteService {
    JobDao jobDao = new JobDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();
    UserDao studentDao = new StudentDaoImpl();

    @Override
    public boolean delete(int userId, int courseId) {
        List<Job> jobList = jobDao.queryJobsByCourseId(courseId);
        for (Job j : jobList) {
            if (jobDao.queryPosterByJobId(j.getId()).getId() == userId) {
                if (!jobDao.delete(userId, j.getId())) {
                    return false;
                }
            } else {
                List<Apply> applies = jobDao.queryApplies(j.getId());
                for (Apply apply : applies) {
                    if (apply.getUserId() == userId) {
                        studentDao.deleteApply(userId, j.getId());
                    }
                }
            }
        }
        courseDao.deleteStudent(userId, courseId);
        return true;
    }
}
