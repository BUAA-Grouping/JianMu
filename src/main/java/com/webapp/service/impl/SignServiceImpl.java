package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.SignService;

public class SignServiceImpl implements SignService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public int signIn(String name, String password) {
        if (userDao.queryUserByUsername(name) == null) {
            return -1;
        } else if (userDao.queryByUsernameAndPassword(name, password) == null) {
            return -2;
        }
        return 0;
    }


    @Override
    public int registerUser(String realname, String password, String emailId, int SchoolId) {
        User user = new User(realname, password, emailId, SchoolId);
        if (userDao.queryUserByUsername(realname) != null) {
            return -1;
        }
        userDao.saveUser(user);
        return 0;
    }

    @Override
    public boolean existUser(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
