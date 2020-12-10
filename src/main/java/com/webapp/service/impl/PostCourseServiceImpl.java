package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.pojo.Course;
import com.webapp.pojo.Job;
import com.webapp.service.PostCourseService;

import java.sql.Timestamp;

public class PostCourseServiceImpl implements PostCourseService {
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public boolean post(int id, Course course) {
        return courseDao.createCourse(id,course);
    }
}
