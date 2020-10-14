package com.webapp.dao;

import com.webapp.pojo.User;


public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryByUsernameAndPassword(String username, String password);

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
    public boolean saveUser(User user);

    /**
     * Used to modify personal information
     * Just update email, name, schoolId, password, major, campus, profile.
     *
     * @return false when user does not exists or some infos is not complete.
     */
    public boolean modifyUser(User user);

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
}