package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.UserDaoImpl;
import com.webapp.pojo.User;
import com.webapp.service.DeleteUserService;

public class DeleteUserServiceImpl implements DeleteUserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public int deleteUser(String emailID, String password) {
        User user = userDao.queryByEmail(emailID);
        if (user == null) {
            return -1;
        }
        if (!user.getPassword().equals(password)) {
            return -2;
        }
        if (userDao.delete(emailID)) {
            return 0;
        }
        return -3;
    }
}
