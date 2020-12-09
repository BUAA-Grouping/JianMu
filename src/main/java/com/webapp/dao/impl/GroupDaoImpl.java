package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.GroupDao;
import com.webapp.pojo.Group;

import java.math.BigInteger;

public class GroupDaoImpl extends BaseDao implements GroupDao {
    @Override
    public boolean createGroup(Group group) {
        String sql = "INSERT INTO `group`(title,leader_id,state,job_id) VALUES (?,?,?,?)";
        return update(sql, group.getTitle(), group.getLeaderId(),
                group.getState(), group.getJobId()) > 0;
    }
}
