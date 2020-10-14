package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.ModifyUserService;

public class ModifyUserServiceImpl implements ModifyUserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(String emailId) {
        return userDao.queryInfoByEmail(emailId);
    }

    @Override
    public boolean modify(User user) {
        return userDao.modifyUser(user);
    }
}
