package com.webapp.service;

import com.webapp.pojo.User;

public interface SignService {
    public User signIn(User user);

    public boolean existUser(String username);

    public void registUser(User user);
}
