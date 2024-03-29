package com.webapp.dao;

import com.webapp.pojo.*;

import java.util.List;

public interface CourseDao {
    /**
     * ensure the user is a teacher
     * will fill in the course.id
     *
     * @param userId user_id of teacher
     * @param course course
     * @return succeed creating course or not
     */
    boolean createCourse(int userId, Course course);

    boolean applyCourse(Study study);

    boolean deleteCourse(int courseId);

    Course queryInfoByCourseId(int courseId);

    List<Teacher> queryTeachersByCourseId(int courseId);

    List<Student> queryStudentsByCourseId(int courseId);

    /**
     * ensure the user is a teacher
     *
     * @param userId user_id of teacher
     * @return list of taught courses
     */
    List<Course> queryTaughtCourses(int userId);

    /**
     * ensure the user is a student
     *
     * @param userId user_id of student
     * @return list of studied courses
     */
    List<Course> queryStudiedCourses(int userId);

    List<Course> queryCoursesByConditions(String courseName, String teacherName, int courage);

    List<Study> queryStudies(int courseId);

    boolean replyStudy(Study study);

    boolean deleteStudent(int userId, int courseId);
}
