package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.pojo.Course;
import com.webapp.pojo.Job;
import com.webapp.pojo.Teacher;
import com.webapp.service.SearchCourseService;

import java.util.ArrayList;
import java.util.List;

public class SearchCourseServiceImpl implements SearchCourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public int searchCourse(String keyword, int college, String teacher, ArrayList<Course> courseList, List<Teacher> teachers) {
        courseList.addAll(courseDao.queryCourseByConditions(keyword, college, teacher));
        for (Course c : courseList) {
            teachers.add(courseDao.queryTeachersByCourseId(c.getId()).get(0));
        }
        if (courseList.isEmpty()) {
            return -1;
        }
        return 0;
    }

    @Override
    public Course getDetail(int courseId) {
        return courseDao.queryInfoByCourseId(courseId);
    }

    @Override
    public Teacher getTeacher(int courseId) {
        return courseDao.queryTeachersByCourseId(courseId).get(0);
    }
}
