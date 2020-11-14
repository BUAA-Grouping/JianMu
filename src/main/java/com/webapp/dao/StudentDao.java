package com.webapp.dao;

import com.webapp.pojo.Student;

public interface StudentDao extends UserDao {
    public boolean saveStudent(Student student);

    public boolean modifyStudent(Student student);

    @Override
    public Student queryByEmail(String email);
}
