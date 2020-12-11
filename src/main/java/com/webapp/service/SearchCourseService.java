package com.webapp.service;

import com.webapp.pojo.*;

import java.util.ArrayList;
import java.util.List;

public interface SearchCourseService {

    int searchCourse(String keyword, int college, String teacher, ArrayList<Course> courseList, List<Teacher> teachers);

    void getDetail(int courseId, Course course, Teacher teacher, List<Job> jobList, List<List<User>> studentList);

    Teacher getTeacher(int courseId);

    List<Course> getCourse(int teacherId);

    boolean getCourse(int teacherId, List<Course> courseList, List<List<User>> studentList);
}
