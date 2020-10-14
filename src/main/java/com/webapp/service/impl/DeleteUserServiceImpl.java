package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.DeleteUserService;

public class DeleteUserServiceImpl implements DeleteUserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public int deleteUser(String emailID) {
        if (userDao.delete(emailID)) {
            return 0;
        }
        return -1;
    }
}
