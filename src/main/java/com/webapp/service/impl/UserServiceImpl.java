package com.webapp.service.impl;

import com.webapp.dao.GroupDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.GroupDaoImpl;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.pojo.Apply;
import com.webapp.pojo.Group;
import com.webapp.pojo.Student;
import com.webapp.pojo.User;
import com.webapp.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new StudentDaoImpl();

    @Override
    public User getUser(String emailId) {
        return userDao.queryInfoByEmail(emailId);
    }

    @Override
    public boolean modify(Student student) {
        return userDao.modify(student);
    }

    public User getUserByUserId(int userId) {
        return userDao.queryInfoById(userId);
    }

    @Override
    public boolean join(int userId, int jobId) {
        Group group = new GroupDaoImpl().queryGroupByJobId(jobId);
        return userDao.join(userId, group.getId());
    }

    @Override
    public List<Apply> getApplies(int id) {
        return userDao.queryApplies(id);
    }
}
