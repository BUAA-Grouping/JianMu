package com.webapp.service;

import com.webapp.pojo.Course;
import com.webapp.pojo.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface SearchCourseService {

    int searchCourse(String keyword, int college, String teacher, ArrayList<Course> courseList, List<Teacher> teachers);

    Course getDetail(int courseId);

    Teacher getTeacher(int courseId);
}
