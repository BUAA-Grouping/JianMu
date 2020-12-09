package com.webapp.dao;

import com.webapp.pojo.Group;

public interface GroupDao {
    public boolean createGroup(Group group);

    public Group queryGroupByJobId(int jobId);
}
