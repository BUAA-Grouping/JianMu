package com.webapp.service.impl;

import com.sun.org.apache.bcel.internal.generic.GotoInstruction;
import com.webapp.dao.GroupDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.impl.GroupDaoImpl;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Group;
import com.webapp.pojo.Job;
import com.webapp.service.PostJobService;

import java.sql.Timestamp;

public class PostJobServiceImpl implements PostJobService {
    private JobDao jobDao = new JobDaoImpl();
    private GroupDao groupDao = new GroupDaoImpl();

    public boolean post(int id, Job job, Timestamp expectedEndtime) {
        return jobDao.post(id, job, expectedEndtime);
    }

    public boolean createGroup(Job job, int id) {
        Group group = new Group();
        group.setTitle(job.getTitle());
        group.setLeaderId(id);
        group.setState(1);
        group.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return groupDao.createGroup(group);
    }
}
