package com.webapp.dao;

import com.webapp.pojo.Job;

import java.util.List;

public interface JobDao {
    void delete(int job_id);
    int queryPostUserIdByJobId(int job_id);
    List<Job> queryJobByConditions(String keyword,int college,int campus);
}
