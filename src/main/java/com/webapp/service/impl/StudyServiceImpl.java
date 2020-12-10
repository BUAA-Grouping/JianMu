package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.pojo.Study;
import com.webapp.service.StudyService;

import java.util.List;

public class StudyServiceImpl implements StudyService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public boolean study(Study study) {
        return courseDao.applyCourse(study);
    }

    @Override
    public List<Study> query(int courseId) {
        return null;
    }
}
