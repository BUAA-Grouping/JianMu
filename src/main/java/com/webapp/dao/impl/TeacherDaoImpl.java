package com.webapp.dao.impl;

import com.webapp.pojo.Teacher;
import com.webapp.pojo.User;

public class TeacherDaoImpl extends UserDaoImpl {
    @Override
    public boolean save(User user) {
        if (!(user instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) user;
        if (teacher.getTeacherId() == null || !super.save(teacher)) {
            return false;
        }

        String sql = "INSERT INTO teacher(user_id,teacher_id,title) VALUES(?,?,?)";
        try {
            return update(sql, teacher.getId(), teacher.getTeacherId(), teacher.getTitle()) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean modify(User user) {
        if (!(user instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) user;
        if (teacher.getTeacherId() == null || !super.modify(teacher)) {
            return false;
        }

        String sql = "UPDATE teacher SET teacher_id=? WHERE `user_id`=?";
        return update(sql, teacher.getTeacherId(), teacher.getId()) > 0;
    }

    @Override
    public Teacher queryInfoById(int id) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId," +
                "campus,`password`,`college_id` collegeId,`profile`,`teacher_id` teacherId,title" +
                " FROM user,teacher WHERE user.id=teacher.user_id AND user.`id`=?";
        return queryForOne(Teacher.class, sql, id);
    }

    @Override
    public Teacher queryInfoByEmail(String email) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId," +
                "campus,`password`,`college_id` collegeId,`profile`,`teacher_id` teacherId,title" +
                " FROM user,teacher WHERE user.id=teacher.user_id AND user.email=?";
        return queryForOne(Teacher.class, sql, email);
    }

    @Override
    public boolean delete(String emailId) {
        Teacher teacher = queryInfoByEmail(emailId);
        String sql = "DELETE FROM teacher WHERE `user_id`=?";
        update(sql, teacher.getId());
        return super.delete(emailId);
    }

    @Override
    public Teacher queryByEmail(String email) {
        String sql = "SELECT `id`,`name`,`email` `emailID`,`password` FROM user WHERE `email`=?";
        return queryForOne(Teacher.class, sql, email);
    }
}
