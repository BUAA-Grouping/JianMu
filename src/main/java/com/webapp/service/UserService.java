package com.webapp.service;

import com.webapp.pojo.Student;
import com.webapp.pojo.User;

public interface UserService {
    User getUser(String emailId);

    User getUserByUserId(int userId);

    boolean modify(Student user);
}
