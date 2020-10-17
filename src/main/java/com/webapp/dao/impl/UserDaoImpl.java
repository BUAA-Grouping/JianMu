package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `school_id` AS schoolID,`name`,`password` FROM user WHERE `name` = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `school_id` AS schoolID,`name`,`password` FROM user WHERE `name` = ? AND `password` = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public User queryByEmail(String email) {
        String sql = "SELECT `id`,`name`,`email` `emailID`,`password` FROM user WHERE `email`=?";
        return queryForOne(User.class, sql, email);
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "INSERT INTO user(`email`,`school_id`,`name`,`password`) values(?,?,?,?)";
        if (user.getEmailID() == null || user.getSchoolId() == 0 || user.getName() == null
                || user.getPassword() == null || this.queryByEmail(user.getEmailID()) != null) {
            return false;
        }
        try {
            return update(sql, user.getEmailID(), user.getSchoolId(), user.getName(), user.getPassword()) > 0;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean modifyUser(User user) {
        if (user.getEmailID() == null || user.getSchoolId() == 0 || user.getName() == null
                || queryInfoById(user.getId()) == null) {
            return false;
        }
        String sql = "UPDATE user SET `email`=?,`name`=?,`school_id`=?,`major`=?,`campus`=?,`profile`=? WHERE `id`=?";
        return update(sql, user.getEmailID(), user.getName(), user.getSchoolId(),
                user.getMajor(), user.getCampus(), user.getProfile(), user.getId()) >= 0;
    }

    @Override
    public User queryInfoById(int id) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`school_id` schoolId,`password`,`major`,`campus`,`profile` FROM user WHERE `id`=?";
        return queryForOne(User.class, sql, id);
    }

    @Override
    public User queryInfoByEmail(String email) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`school_id` AS schoolId,`password`,`major`,`campus`,`profile` FROM user WHERE `email`=?";
        return queryForOne(User.class, sql, email);
    }

    @Override
    public int logIn(int userId) {
        String sql = "UPDATE user SET `last_login_at`=CURRENT_TIMESTAMP WHERE id=?";
        return update(sql, userId);
    }

    @Override
    public int logIn(String email) {
        String sql = "UPDATE user SET `last_login_at`=CURRENT_TIMESTAMP WHERE email=?";
        return update(sql, email);
    }

    @Override
    public boolean delete(String emailId) {
        User user = queryInfoByEmail(emailId);
        if (user == null) {
            return false;
        }
        int userId = user.getId();
        String sql = "SELECT `job_id` `id` FROM `post` WHERE user_id=?";
        List<Job> jobs = queryForList(Job.class, sql, userId);
        sql = "DELETE FROM `post` WHERE user_id=?";
        update(sql, userId);
        sql = "DELETE FROM `job` WHERE job_id=?";
        for (Job job : jobs) {
            update(sql, job.getId());
        }
        sql = "DELETE FROM `user` WHERE `email`=?";
        return update(sql, emailId) > 0;
    }

}