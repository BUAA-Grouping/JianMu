package com.webapp.service;

import com.webapp.pojo.User;

public interface SignService {
    public int signIn(String emailID,String password);

    public boolean existUser(String username);

    public int registerUser(String realname, String password,String emailId,int SchoolId);
}
