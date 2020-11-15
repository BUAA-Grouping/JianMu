package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.User;
import com.webapp.service.ModifyUserService;

public class ModifyUserServiceImpl implements ModifyUserService {
    private UserDao userDao = new StudentDaoImpl();

    @Override
    public User getUser(String emailId) {
        return userDao.queryInfoByEmail(emailId);
    }

    @Override
    public boolean modify(Student student) {
        return userDao.modify(student);
    }
}
