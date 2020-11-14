package com.webapp.dao.impl;

import com.webapp.dao.CollegeDao;
import com.webapp.dao.StudentDao;
import com.webapp.pojo.Student;

public class StudentDaoImpl extends UserDaoImpl implements StudentDao {
    private static final CollegeDao COLLEGE_DAO = new CollegeDaoImpl();

    @Override
    public boolean saveStudent(Student student) {
        if (student.getStudentId() == null || !saveUser(student)) {
            return false;
        }

        String sql = "INSERT INTO student(user_id, student_id) VALUES(?,?)";
        try {
          return update(sql, student.getId(), student.getStudentId()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean modifyStudent(Student student) {
        if (student.getStudentId() == null || !modifyUser(student)) {
            return false;
        }

        String sql = "UPDATE student SET student_id=? WHERE `user_id`=?";
        return update(sql, student.getStudentId(), student.getId()) > 0;
    }

    @Override
    public Student queryInfoById(int id) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId," +
                "`password`,`college_id` collegeId,`profile` FROM user WHERE `id`=?";
        Student student = queryForOne(Student.class, sql, id);
        if (student == null) {
            return null;
        }
        student.setCollege(COLLEGE_DAO.queryInfoByCollegeId(student.getCollegeId()));
        sql = "SELECT `student_id` studentId FROM student WHERE `user_id`=?";
        student.setStudentId(queryForOne(Student.class, sql, student.getId()).getStudentId());
        return student;
    }

    @Override
    public Student queryInfoByEmail(String email) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`password`,`college_id` collegeId,`profile` FROM user WHERE `email`=?";
        Student student = queryForOne(Student.class, sql, email);
        if (student == null) {
            return null;
        }
        student.setCollege(COLLEGE_DAO.queryInfoByCollegeId(student.getCollegeId()));
        sql = "SELECT `student_id` studentId FROM student WHERE `user_id`=?";
        student.setStudentId(queryForOne(Student.class, sql, student.getId()).getStudentId());
        return student;
    }

    @Override
    public boolean delete(String emailId) {
        Student student = queryInfoByEmail(emailId);
        String sql = "DELETE FROM student WHERE `user_id`=?";
        update(sql, student.getId());
        return super.delete(emailId);
    }

    @Override
    public Student queryByEmail(String email) {
        String sql = "SELECT `id`,`name`,`email` `emailID`,`password` FROM user WHERE `email`=?";
        Student student = queryForOne(Student.class, sql, email);
        return student;
    }
}
