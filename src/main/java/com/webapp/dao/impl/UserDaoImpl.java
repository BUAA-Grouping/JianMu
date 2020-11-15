package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CollegeDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.math.BigInteger;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    private static final CollegeDao COLLEGE_DAO = new CollegeDaoImpl();

    @Override
    public User queryByEmail(String email) {
        String sql = "SELECT `id`,`name`,`email` `emailID`,`password`,campus FROM user WHERE `email`=?";
        User user = queryForOne(User.class, sql, email);
        if (user == null) {
            return null;
        }
        user.setCollege(COLLEGE_DAO.queryInfoByCollegeId(user.getCollegeId()));
        return user;
    }

    @Override
    public boolean save(User user) {
        String sql = "INSERT INTO user(`email`,`name`,`password`) values(?,?,?)";
        if (user.getEmailID() == null || user.getName() == null
                || user.getPassword() == null || this.queryByEmail(user.getEmailID()) != null) {
            return false;
        }
        try {
            int userId = ((BigInteger) insert(sql,
                    user.getEmailID(), user.getName(), user.getPassword()))
                    .intValue();
            if (userId <= 0) {
                return false;
            }
            user.setId(userId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean modify(User user) {
        if (user.getEmailID() == null || user.getName() == null
                || queryInfoById(user.getId()) == null) {
            return false;
        }
        String sql = "UPDATE user SET `email`=?,`name`=?,`college_id`=?,`profile`=?,campus=? WHERE `id`=?";
        return update(sql, user.getEmailID(), user.getName(),
                user.getCollegeId(), user.getProfile(), user.getCampus(), user.getId()) >= 0;
    }

    @Override
    public User queryInfoById(int id) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`college_id` collegeId,campus," +
                "`password`,`college_id` collegeId,`profile` FROM user WHERE `id`=?";
        User user = queryForOne(User.class, sql, id);
        if (user == null) {
            return null;
        }
        user.setCollege(COLLEGE_DAO.queryInfoByCollegeId(user.getCollegeId()));
        return user;
    }

    @Override
    public User queryInfoByEmail(String email) {
        String sql = "SELECT `id`,`email` `emailID`,`name`,`password`,`college_id` collegeId," +
                "campus,`profile` FROM user WHERE `email`=?";
        User user = queryForOne(User.class, sql, email);
        if (user == null) {
            return null;
        }
        user.setCollege(COLLEGE_DAO.queryInfoByCollegeId(user.getCollegeId()));
        return user;
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
        User user = queryByEmail(emailId);
        if (user == null) {
            return false;
        }
        int userId = user.getId();
        String sql = "SELECT `job_id` `id` FROM `user_post_job` WHERE user_id=?";
        List<Job> jobs = queryForList(Job.class, sql, userId);
        sql = "DELETE FROM user_post_job WHERE user_id=?";
        update(sql, userId);
        sql = "DELETE FROM `job` WHERE job_id=?";
        for (Job job : jobs) {
            update(sql, job.getId());
        }
        sql = "DELETE FROM `user` WHERE `email`=?";
        return update(sql, emailId) > 0;
    }

}