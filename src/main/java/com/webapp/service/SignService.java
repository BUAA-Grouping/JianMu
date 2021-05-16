package com.webapp.service;

import com.webapp.pojo.User;

public interface SignService {
    int signIn(String emailID, String password, User retUser);

    int registerUser(String realname, String password, String emailId, String id, int type);
}
