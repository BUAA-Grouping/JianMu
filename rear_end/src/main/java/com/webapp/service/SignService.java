package com.webapp.service;

import com.webapp.pojo.User;

public interface SignService {
    public int signIn(String name,String password);

    public boolean existUser(String username);

    public int registUser(String name,String password);
}
