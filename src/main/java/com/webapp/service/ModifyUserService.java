package com.webapp.service;

import com.webapp.pojo.User;

public interface ModifyUserService {
    User getUser(String emailId);

    boolean modify(User user);
}
