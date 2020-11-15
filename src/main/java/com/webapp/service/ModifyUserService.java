package com.webapp.service;

import com.webapp.pojo.Student;
import com.webapp.pojo.User;

public interface ModifyUserService {
    User getUser(String emailId);

    boolean modify(Student user);
}
