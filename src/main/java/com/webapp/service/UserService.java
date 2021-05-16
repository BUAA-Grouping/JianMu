package com.webapp.service;

import com.webapp.pojo.Apply;
import com.webapp.pojo.Student;
import com.webapp.pojo.Teacher;
import com.webapp.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(String emailId);

    User getUserByUserId(int userId);

    boolean modify(Student user);

    boolean modify(Teacher teacher);

    boolean join(int userId, int jobId);

    List<Apply> getApplies(int id);
}
