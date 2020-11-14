package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CollegeDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class JobDaoImpl extends BaseDao implements JobDao {
    private static UserDao userDao = new UserDaoImpl();
    private static final CollegeDao COLLEGE_DAO = new CollegeDaoImpl();

    @Override
    public boolean post(int userId, Job job, Timestamp expectedEndTime) {
        if (job == null || userDao.queryInfoById(userId) == null) {
            return false;
        }
        job.setState(1);
        String sql = "INSERT INTO job(`title`,`college_id`,`expected_num_of_member`,`state`,`profile`,`email`,`telephone`)" +
                " VALUES (?,?,?,?,?,?,?)";
        int jobId = ((BigInteger) insert(sql, job.getTitle(), job.getCollegeId(), job.getExceptedNumOfMember(),
                job.getState(), job.getProfile(), job.getEmail(), job.getTelephone())).intValue();
        sql = "INSERT INTO user_post_job(`user_id`,`job_id`,`expected_end_time`) VALUES (?,?,?)";
        update(sql, userId, jobId, expectedEndTime);
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
        String sql = "SELECT `id`,`title`,college_id collegeId,expected_num_of_member exceptedNumOfMember," +
                "`state`,`profile`,`telephone`,`email`" +
                " FROM job WHERE `id`=?";
        Job job = queryForOne(Job.class, sql, jobId);
        job.setCollege(COLLEGE_DAO.queryInfoByCollegeId(job.getCollegeId()));
        return job;
    }

    @Override
    public User queryPosterByJobId(int jobId) {
        String sql = "SELECT post.user_id `id`,`email`,`name`,`password`," +
                "`college_id` collegeId,`profile`" +
                " FROM post INNER JOIN user ON post.user_id=user.id WHERE `job_id`=?";
        User user = queryForOne(User.class, sql, jobId);
        user.setCollege(COLLEGE_DAO.queryInfoByCollegeId(user.getCollegeId()));
        return user;
    }

    @Override
    public List<Job> queryJobByConditions(String keyword, int college, int campus) {
        String sql = "SELECT `id`,`title`,`college_id` collegeId,`expected_num_of_member` AS `exceptedNumOfMember`," +
                "`state`,`profile`,`telephone`,`email`" +
                " FROM job";
        if ((keyword == null || keyword.isEmpty()) && college == 0 && campus == 0) {
            return queryForList(Job.class, sql);
        }
        sql += " WHERE ";
        if (keyword != null && !keyword.isEmpty()) {
            sql += " `title` LIKE '%" + keyword + "%' AND ";
        }
        if (college != 0) {
            sql += " `college_id`=" + college + " AND ";
        }
        sql = sql.replaceAll(" AND $", "");
        List<Job> jobs = queryForList(Job.class, sql);
        for (Job job : jobs) {
            job.setCollege(COLLEGE_DAO.queryInfoByCollegeId(job.getCollegeId()));
        }
        return jobs;
    }

    @Override
    public List<Job> queryJobByPoster(int userId) {
        String sql = "SELECT job.id, `title`,`college_id` collegeId,`expected_num_of_member` AS `exceptedNumOfMember`," +
                "`state`,`profile`,`telephone`,`email` " +
                "FROM user_post_job,job " +
                "WHERE `user_id`=? AND job.id=user_post_job.job_id";
        List<Job> jobs = queryForList(Job.class, sql, userId);
        for (Job job : jobs) {
            job.setCollege(COLLEGE_DAO.queryInfoByCollegeId(job.getCollegeId()));
        }
        return jobs;
    }

    @Override
    public Timestamp queryEndTimeByJobId(int jobId) {
        String sql = "SELECT expected_end_time `expectedEndTime` FROM `post` WHERE job_id=?";
        return queryForSingleValue(sql, jobId);
    }

    @Override
    public Timestamp queryStartTimeByJobId(int jobId) {
        String sql = "SELECT create_at `startTime` FROM `job` WHERE id=?";
        return queryForSingleValue(sql, jobId);
    }
}
