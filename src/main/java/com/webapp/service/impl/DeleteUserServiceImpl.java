package com.webapp.service.impl;

import com.webapp.dao.StudentDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.User;
import com.webapp.service.DeleteUserService;

public class DeleteUserServiceImpl implements DeleteUserService {
    private final UserDao userDao = new UserDaoImpl();
    private final StudentDao studentDao = new StudentDaoImpl();
    @Override
    public int deleteUser(String emailID) {
        if (studentDao.delete(emailID)) {
            return 0;
        }
        return -1;
    }
}
