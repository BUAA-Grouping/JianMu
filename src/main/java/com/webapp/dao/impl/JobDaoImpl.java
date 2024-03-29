package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CollegeDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.Apply;
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
        String sql = "INSERT INTO job(`title`,`college_id`,`campus`,`expected_num_of_member`," +
                "`state`,`profile`,`email`,`telephone`,course_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?)";
        int jobId = ((BigInteger) insert(sql, job.getTitle(), job.getCollege(), job.getCampus(),
                job.getExceptedNumOfMember(), job.getState(), job.getProfile(), job.getEmailId(),
                job.getTelephone(),job.getCourseId() != 0 ? job.getCourseId() : null)).intValue();
        job.setId(jobId);
        sql = "INSERT INTO user_post_job(`user_id`,`job_id`,`expected_end_time`) VALUES (?,?,?)";
        return update(sql, userId, jobId, expectedEndTime) > 0;
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
        String sql = "SELECT `id`,`title`,college_id college,campus,expected_num_of_member exceptedNumOfMember," +
                "`state`,`profile`,`telephone`,`email`" +
                " FROM job WHERE `id`=?";
        return queryForOne(Job.class, sql, jobId);
    }

    @Override
    public User queryPosterByJobId(int jobId) {
        String sql = "SELECT user.`id`,`email` emailID,`name`,`password`," +
                "`college_id` collegeId,`profile`,campus" +
                " FROM user_post_job INNER JOIN user ON user_post_job.user_id=user.id WHERE `job_id`=?";
        return queryForOne(User.class, sql, jobId);
    }

    @Override
    public List<Job> queryJobByConditions(String keyword, int college, int campus, int userId) {
        String sql = "SELECT `id`,`title`,`college_id` college,`expected_num_of_member` AS `exceptedNumOfMember`," +
                "`state`,`profile`,`telephone`,`email`,campus " +
                "FROM job " +
                "WHERE (course_id IS NULL OR course_id=0 OR course_id IN (" +
                        "SELECT course_id FROM std_study_course WHERE student_id=? UNION " +
                        "SELECT course_id FROM teacher_teach_course WHERE teacher_id=?)) AND ";
        if (keyword != null && !keyword.isEmpty()) {
            sql += " `title` LIKE '%" + keyword + "%' AND ";
        }
        if (college != 0) {
            sql += " `college_id`=" + college + " AND ";
        }
        if (campus != 0) {
            sql += " `campus`=" + campus + " AND ";
        }
        sql = sql.replaceAll(" AND $", "");
        return queryForList(Job.class, sql, userId, userId);
    }

    @Override
    public List<Job> queryJobByPoster(int userId) {
        String sql = "SELECT job.id, `title`,`college_id` college,`expected_num_of_member` `exceptedNumOfMember`," +
                "`state`,`profile`,`telephone`,`email`,campus " +
                "FROM user_post_job,job " +
                "WHERE `user_id`=? AND job.id=user_post_job.job_id";
        return queryForList(Job.class, sql, userId);
    }

    @Override
    public Timestamp queryEndTimeByJobId(int jobId) {
        String sql = "SELECT expected_end_time `expectedEndTime` FROM user_post_job WHERE job_id=?";
        return queryForSingleValue(sql, jobId);
    }

    @Override
    public Timestamp queryStartTimeByJobId(int jobId) {
        String sql = "SELECT create_at `startTime` FROM `job` WHERE id=?";
        return queryForSingleValue(sql, jobId);
    }

    @Override
    public List<Apply> queryApplies(int jobId) {
        String sql = "SELECT user_id userId,job_id jobId,status," +
                "apply_at applyAt,reply_at replyAt FROM user_apply_job where job_id=?";
        return queryForList(Apply.class, sql, jobId);
    }

    @Override
    public boolean replyApply(Apply apply) {
        if (apply == null) {
            return false;
        }
        String sql = "UPDATE user_apply_job SET status=?,reply_at=? WHERE job_id=? AND user_id=?";
        return update(sql, apply.getStatus(), apply.getReplyAt(),
                apply.getJobId(), apply.getUserId()) > 0;
    }

    @Override
    public List<Job> queryJobsByCourseId(int courseId) {
        String sql = "SELECT `id`,`title`,college_id college,campus,expected_num_of_member exceptedNumOfMember," +
                "`state`,`profile`,`telephone`,`email`" +
                " FROM job WHERE course_id=?";
        return queryForList(Job.class, sql, courseId);
    }
}
