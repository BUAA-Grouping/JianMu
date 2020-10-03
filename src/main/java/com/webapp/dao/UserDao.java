package com.webapp.dao;

import com.webapp.pojo.User;

public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryByUsernameAndPassword(String username, String password);

    public int saveUser(User user);

}
