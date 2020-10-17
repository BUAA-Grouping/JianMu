package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.SignService;

public class SignServiceImpl implements SignService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public int signIn(String emailId, String password, User retUser) {
        User user = userDao.queryByEmail(emailId);
        if (user == null) {
            return -1;
        }
        if (!user.getPassword().equals(password)) {
            return -2;
        }
        retUser.setName(user.getName());
        retUser.setPassword(password);
        retUser.setEmailID(emailId);
        retUser.setId(user.getId());
        userDao.logIn(emailId);
        return 0;
    }


    @Override
    public int registerUser(String realname, String password, String emailId, int SchoolId) {
        User user = new User(realname, password, emailId, SchoolId);
        if (userDao.queryByEmail(emailId) != null) {
            return -1;
        }
        if (!userDao.saveUser(user)) {
            return -2;
        }
        return 0;
    }

    @Override
    public boolean existUser(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
