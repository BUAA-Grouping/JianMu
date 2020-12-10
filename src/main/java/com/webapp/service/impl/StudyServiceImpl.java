package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.TeacherDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.Study;
import com.webapp.pojo.User;
import com.webapp.service.StudyService;

import java.util.List;

public class StudyServiceImpl implements StudyService {
    CourseDao courseDao = new CourseDaoImpl();
    UserDao studentDao = new StudentDaoImpl();
    UserDao teacherDao = new TeacherDaoImpl();

    @Override
    public boolean study(Study study) {
        return courseDao.applyCourse(study);
    }

    @Override
    public List<Study> query(int courseId) {
        return null;
    }

    @Override
    public boolean hadStudied(int userId, int courseId, int type) {
        if (type == 0) {
            return studentDao.isInCourse(userId, courseId);
        } else {
            return teacherDao.isInCourse(userId, courseId);
        }
    }
}
