package com.webapp.dao.impl;

import com.webapp.pojo.Student;
import com.webapp.pojo.User;

public class StudentDaoImpl extends UserDaoImpl {
    @Override
    public boolean save(User user) {
        if (!(user instanceof Student)) {
            return false;
        }
        Student student = (Student) user;
        if (student.getStudentId() == null || !super.save(student)) {
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
    public boolean modify(User user) {
        if (!(user instanceof Student)) {
            return false;
        }
        Student student = (Student) user;
        if (student.getStudentId() == null || !super.modify(student)) {
            return false;
        }

        String sql = "UPDATE student SET student_id=? WHERE `user_id`=?";
        return update(sql, student.getStudentId(), student.getId()) > 0;
    }

    @Override
    public Student queryInfoById(int id) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId," +
                "campus,`password`,`college_id` collegeId,`profile`,`student_id` studentId" +
                " FROM user,student WHERE user.id=student.user_id AND user.`id`=?";
        return queryForOne(Student.class, sql, id);
    }

    @Override
    public Student queryInfoByEmail(String email) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId," +
                "campus,`password`,`college_id` collegeId,`profile`,`student_id` studentId" +
                " FROM user,student WHERE user.id=student.user_id AND user.email=?";
        return queryForOne(Student.class, sql, email);
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
        return queryForOne(Student.class, sql, email);
    }
}
