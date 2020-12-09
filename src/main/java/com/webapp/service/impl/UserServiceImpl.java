package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.User;
import com.webapp.service.UserService;

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
}
