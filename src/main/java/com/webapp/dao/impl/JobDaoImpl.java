package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.sql.Timestamp;
import java.util.List;

public class JobDaoImpl extends BaseDao implements JobDao {
    private static UserDao userDao = new UserDaoImpl();

    @Override
    public boolean post(int userId, Job job, Timestamp expectedEndTime) {
        if (job == null || userDao.queryInfoById(userId) == null) {
            return false;
        }
        job.setState(1);
        String sql = "INSERT INTO job(`title`,`college`,`campus`,`expected_number_of_member`,`state`,`profile`) VALUES (?,?,?,?,?,?)";
        update(sql, job.getTitle(), job.getCollege(), job.getCampus(), job.getExceptedNumOfMember(), job.getState(), job.getProfile());
        if (expectedEndTime == null) {
            sql = "INSERT INTO post(`user_id`,`job_id`) VALUES (?,?)";
            update(sql, userId, job.getId());
        } else {
            sql = "INSERT INTO post(`user_id`,`job_id`,`expected_end_time`) VALUES (?,?,?)";
            update(sql, userId, job.getId(), expectedEndTime);
        }
        return true;
    }

    @Override
    public boolean delete(int userId, int jobId) {
        User user = this.queryPosterByJobId(jobId);
        if (user == null || user.getId() != userId) {
            return false;
        }
        String sql = "DELETE FROM post WHERE `user_id`=? AND `job_id`=?";
        update(sql, userId, jobId);
        sql = "DELETE FROM job WHERE `id`=?";
        update(sql, jobId);
        return true;
    }

    @Override
    public Job queryInfoByJobId(int jobId) {
        String sql = "SELECT `id`,`title`,`college`,`campus`,`expected_number_of_member` AS `exceptedNumOfMember`,`state`,`profile`" +
                " FROM job WHERE `id`=?";
        return queryForOne(Job.class, sql, jobId);
    }

    @Override
    public User queryPosterByJobId(int jobId) {
        String sql = "SELECT post.user_id AS `id`,`email`,`name`,`school_id` AS schoolId,`password`,`major`,`campus`,`profile`" +
                " FROM post INNER JOIN user ON post.user_id=user.id WHERE `job_id`=?";
        return queryForOne(User.class, sql, jobId);
    }

    @Override
    public List<Job> queryJobByConditions(String keyword, int college, int campus) {
        String sql = "SELECT `id`,`college`,`campus`,`expected_number_of_member` AS `exceptedNumOfMember`,`state`,`profile`" +
                " FROM job";
        if (keyword != null && college != 0 && campus != 0) {
            return queryForList(Job.class, sql);
        }
        sql += " WHERE ";
        if (keyword != null) {
            sql += " `title` LIKE '%" + keyword + "%' AND ";
        }
        if (college != 0) {
            sql += " `college`=" + college + " AND ";
        }
        if (campus != 0) {
            sql += " `campus`=" + campus + " AND ";
        }
        sql = sql.replaceAll(" AND $", "");
        return queryForList(Job.class, sql);
    }
}