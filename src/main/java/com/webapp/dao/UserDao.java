package com.webapp.dao;

import com.webapp.pojo.User;

public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryByUserameAndPassWord(String username, String password);

    public int saveUer(User user);

}
