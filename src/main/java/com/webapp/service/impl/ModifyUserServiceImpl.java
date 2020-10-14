package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.ModifyUserService;

public class ModifyUserServiceImpl implements ModifyUserService {
    @Override
    public User getUser(String emailId) {
        return null;
    }

    @Override
    public boolean modify(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.modifyUser(user);
    }
}
