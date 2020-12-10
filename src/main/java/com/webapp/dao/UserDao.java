package com.webapp.dao;

import com.webapp.pojo.Apply;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;

import java.util.List;


public interface UserDao {
    /**
     * Used to log in.
     * Return null when it fails. Return user with id, name, email, password.
     */
    public User queryByEmail(String email);

    /**
     * Used to register.
     * Ensure that user.email, user.name, user.schoolId, user.password were not null.
     * Return false when user exists or info is not complete.
     */
    public boolean save(User user);

    /**
     * Used to modify personal information
     * Just update email, name, schoolId, major, campus, profile.
     *
     * @return false when user does not exists or some infos is not complete.
     */
    public boolean modify(User user);

    /**
     * Used to get user's info.
     * Return null when it fails. Return user with id, email, name, schoolId, password,
     * major, campus, profile when it succeeds.
     */
    public User queryInfoById(int id);

    public User queryInfoByEmail(String email);

    /**
     * Used to update the last log in time.
     * It is used when it succeeds in logging in.
     */
    public int logIn(int userId);

    public int logIn(String email);

    public boolean delete(String emailId);

    public boolean applyJob(Apply apply);

    public List<Apply> queryApplies(int userId);

    public boolean join(int userId, int groupId);

    public boolean isInCourse(int userId, int courseId);
}
