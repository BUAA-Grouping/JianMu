package com.webapp.dao;

import com.webapp.pojo.College;

public interface CollegeDao {
    public College queryInfoByCollegeId(int collegeId);
}
