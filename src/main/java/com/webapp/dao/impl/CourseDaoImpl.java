package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CourseDao;
import com.webapp.pojo.Course;
import com.webapp.pojo.Student;
import com.webapp.pojo.Teacher;

import java.math.BigInteger;
import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {

    @Override
    public boolean createCourse(int userId, Course course) {
        String sql = "SELECT user_id FROM teacher WHERE user_id=?";
        if (course == null || queryForOne(Teacher.class, sql, userId) == null) {
            return false;
        }
        sql = "INSERT INTO course(title,capacity,profile,college_id) VALUES (?,?,?,?)";
        int courseId = ((BigInteger) insert(sql, course.getTitle(), course.getCapacity(),
                course.getProfile(), course.getCollege())).intValue();
        course.setId(courseId);
        sql = "INSERT INTO teacher_teach_course(teacher_id, course_id) VALUES (?,?)";
        return update(sql, userId, courseId) > 0;
    }

    @Override
    public boolean applyCourse(int userId, int courseId) {
        return false;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return false;
    }

    @Override
    public Course queryInfoByCourseId(int courseId) {
        return null;
    }

    @Override
    public List<Teacher> queryTeachersByCourseId(int courseId) {
        return null;
    }

    @Override
    public List<Student> queryStudentsByCourseId(int courseId) {
        return null;
    }

    @Override
    public List<Course> queryTaughtCourses(int userId) {
        return null;
    }

    @Override
    public List<Course> queryStudiedCourses(int userId) {
        return null;
    }
}
