package com.webapp.service;

import com.webapp.pojo.User;

public interface SignService {
    public int signIn(String emailID,String password,User retUser);

    public int registerUser(String realname, String password,String emailId,String SchoolId);
}
