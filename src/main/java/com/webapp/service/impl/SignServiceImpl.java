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
        } else if (userDao.queryByUserameAndPassWord(name, password) == null) {
            return -2;
        }
        return 0;
    }


    @Override
    public int registUser(String name, String password) {
        User user = new User(name, password);
        if (userDao.queryUserByUsername(name) != null) {
            return -1;
        }
        userDao.saveUer(user);
        return 0;
    }

    @Override
    public boolean existUser(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
