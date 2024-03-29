package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CourseDao;
import com.webapp.pojo.*;

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
    public boolean applyCourse(Study study) {
        String sql = "SELECT user_id FROM student WHERE user_id=?";
        if (study == null || queryForOne(Student.class, sql, study.getStudentId()) == null) {
            return false;
        }
        sql = "INSERT INTO std_study_course(student_id, course_id, status) VALUES (?,?,1)";
        return update(sql, study.getStudentId(), study.getCourseId()) > 0;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return false;
    }

    @Override
    public Course queryInfoByCourseId(int courseId) {
        String sql = "SELECT `id`,title,capacity,profile,college_id collegeId,create_at createAt" +
                " FROM course WHERE `id`=?";
        return queryForOne(Course.class, sql, courseId);
    }

    @Override
    public List<Teacher> queryTeachersByCourseId(int courseId) {
        String sql = "SELECT teacher.user_id id, name, title " +
                "FROM teacher_teach_course,teacher,`user` " +
                "WHERE course_id=? AND " +
                "teacher_teach_course.teacher_id=teacher.user_id AND " +
                "teacher.user_id=user.id";
        return queryForList(Teacher.class, sql, courseId);
    }

    @Override
    public List<Student> queryStudentsByCourseId(int courseId) {
        String sql = "SELECT student_id FROM std_study_course WHERE course_id=?";
        return queryForList(Student.class, sql, courseId);
    }

    @Override
    public List<Course> queryTaughtCourses(int userId) {
        String sql = "SELECT `id`, title, capacity, profile, " +
                "college_id collegeId, create_at createAt FROM course " +
                "WHERE `id` IN (SELECT course_id FROM teacher_teach_course WHERE teacher_id=?)";
        return queryForList(Course.class, sql, userId);
    }

    @Override
    public List<Course> queryStudiedCourses(int userId) {
        return null;
    }

    @Override
    public List<Course> queryCoursesByConditions(String courseName, String teacherName, int college) {
        String sql = "SELECT DISTINCT course.id,course.title,capacity," +
                "course.college_id collegeId,course.create_at createAt " +
                "FROM course,teacher_teach_course,teacher,`user`";
        if ((courseName == null || courseName.isEmpty()) &&
                (teacherName == null || teacherName.isEmpty()) && college == 0) {
            return queryForList(Course.class, sql);
        }
        sql += " WHERE ";
        if (courseName != null && !courseName.isEmpty()) {
            sql += "course.title LIKE '%" + courseName + "%' AND ";
        }
        if (teacherName != null && !teacherName.isEmpty()) {
            sql += "course.id=teacher_teach_course.course_id AND " +
                    "teacher_teach_course.teacher_id=teacher.user_id AND " +
                    "teacher.user_id=user.id AND " +
                    "user.name LIKE '%" + teacherName + "%' AND ";
        }
        if (college != 0) {
            sql += "course.college_id=" + college + " AND ";
        }
        sql = sql.replaceAll(" AND $", "");
        return queryForList(Course.class, sql);
    }

    @Override
    public List<Study> queryStudies(int courseId) {
        String sql = "SELECT student_id studentId,course_id courseId,status," +
                "apply_at applyAt,reply_at replyAt " +
                "FROM std_study_course WHERE course_id=?";
        return queryForList(Study.class, sql, courseId);
    }

    @Override
    public boolean replyStudy(Study study) {
        if (study == null) {
            return false;
        }
        String sql = "UPDATE std_study_course SET status=?,reply_at=? WHERE course_id=? AND student_id=?";
        return update(sql, study.getStatus(), study.getReplyAt(),
                study.getCourseId(), study.getStudentId()) > 0;
    }

    @Override
    public boolean deleteStudent(int userId, int courseId) {
        String sql = "DELETE FROM std_study_course WHERE student_id=? AND course_id=?";
        return update(sql, userId, courseId) > 0;
    }


}
