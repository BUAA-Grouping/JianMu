package com.webapp.service;

import com.webapp.pojo.Course;
import com.webapp.pojo.Job;

import java.sql.Timestamp;

public interface PostCourseService {
    boolean post(int id, Course course);
}
