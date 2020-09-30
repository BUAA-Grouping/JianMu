package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.SignService;

public class SignServiceImpl implements SignService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User signIn(User user) {
        return userDao.queryByUserameAndPassWord(user.getUsername(), user.getPassword());
    }


    @Override
    public void registUser(User user) {
        userDao.saveUer(user);
    }

    @Override
    public boolean existUser(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
