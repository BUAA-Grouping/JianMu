package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.CollegeDao;
import com.webapp.pojo.College;

public class CollegeDaoImpl extends BaseDao implements CollegeDao {
    @Override
    public College queryInfoByCollegeId(int collegeId) {
        String sql = "SELECT `id`,`title` FROM college WHERE `id`=?";
        return queryForOne(College.class, sql, collegeId);
    }
}
