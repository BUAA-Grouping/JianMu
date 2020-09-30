package com.webapp.dao.impl;

import com.webapp.dao.BaseDao;
import com.webapp.dao.UserDao;
import com.webapp.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT 'id','username','password' FROM user_table WHERE username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryByUserameAndPassWord(String username, String password) {
        String sql = "SELECT 'id','username','password' FROM user_table WHERE username = ? AND password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUer(User user) {
        String sql = "INSERT INTO user_table('username','password') values(?,?,?)";
        return update(sql, user, user.getUsername(), user.getPassword());
    }
}
