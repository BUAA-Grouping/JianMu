package com.webapp.service.impl;

import com.webapp.dao.StudentDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.User;
import com.webapp.service.ModifyUserService;

public class ModifyUserServiceImpl implements ModifyUserService {
    private UserDao userDao = new UserDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public User getUser(String emailId) {
        return studentDao.queryInfoByEmail(emailId);
    }

    @Override
    public boolean modify(Student student) {
        return studentDao.modifyStudent(student);
    }
}
