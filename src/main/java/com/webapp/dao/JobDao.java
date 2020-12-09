package com.webapp.dao;

import com.webapp.pojo.Apply;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface JobDao {

    /**
     * user post job, update the table job and post.
     * @return true when user exists and job != null.
     */
    boolean post(int userId, Job job, Timestamp expectedEndTime);

    /**
     * poster delete job, update the table job and post.
     * @return true if the job exists and the user is poster of the job.
     */
    boolean delete(int userId, int jobId);

    /**
     * get the info of the job.
     * @return a job if it exists.
     */
    Job queryInfoByJobId(int jobId);

    /**
     * get info of poster of the job if it exists.
     * @return poster if exists, or null.
     */
    User queryPosterByJobId(int jobId);

    /**
     * search for jobs if conditions are met.
     * @return a List of job.
     */
    List<Job> queryJobByConditions(String keyword,int college,int campus);

    /**
     * get jobs the person post
     * @param userId poster's id
     */
    List<Job> queryJobByPoster(int userId);

    Timestamp queryEndTimeByJobId(int jobId);

    Timestamp queryStartTimeByJobId(int jobId);

    List<Apply> queryApplies(int jobId);

    public boolean replyApply(Apply apply);
}
