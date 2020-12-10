package com.webapp.service.impl;

import com.webapp.dao.GroupDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.GroupDaoImpl;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.TeacherDaoImpl;
import com.webapp.pojo.*;
import com.webapp.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new StudentDaoImpl();
    private UserDao teacherDao = new TeacherDaoImpl();

    @Override
    public User getUser(String emailId) {
        User user = userDao.queryInfoByEmail(emailId);
        if (user == null) {
            user = teacherDao.queryInfoByEmail(emailId);
        }
        return user;
    }

    @Override
    public boolean modify(Student student) {
        return userDao.modify(student);
    }

    @Override
    public boolean modify(Teacher teacher) {
        return teacherDao.modify(teacher);
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
