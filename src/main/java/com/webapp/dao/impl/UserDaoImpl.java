package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`,`name`,`password` FROM user WHERE `name` = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,`name`,`password` FROM user WHERE `name` = ? AND `password` = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO user(`id`,`name`,`password`) values(?,?,?)";
        return update(sql, user.getId(), user.getName(), user.getPassword());
    }
}