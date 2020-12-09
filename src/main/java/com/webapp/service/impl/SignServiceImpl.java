package com.webapp.service.impl;

import com.webapp.dao.UserDao;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.dao.impl.TeacherDaoImpl;
import com.webapp.pojo.Student;
import com.webapp.pojo.Teacher;
import com.webapp.pojo.User;
import com.webapp.service.SignService;

public class SignServiceImpl implements SignService {

    private final UserDao studentDao = new StudentDaoImpl();
    private final UserDao teacherDao = new TeacherDaoImpl();

    @Override
    public int signIn(String emailId, String password, User retUser) {

        User user = studentDao.queryByEmail(emailId);
        int type = 0;
        if (user == null) {
            user = teacherDao.queryByEmail(emailId);
            if (user == null) {
                return -1;
            }
            type = 1;
        }
        if (!user.getPassword().equals(password)) {
            return -2;
        }
        retUser.setName(user.getName());
        retUser.setPassword(password);
        retUser.setEmailID(emailId);
        retUser.setId(user.getId());
        if (type == 0) {
            studentDao.logIn(emailId);
        } else {
            teacherDao.logIn(emailId);
        }
        return type;
    }


    @Override
    public int registerUser(String realname, String password, String emailId, String schoolId) {
        Student student = new Student();
        student.setName(realname);
        student.setPassword(password);
        student.setEmailID(emailId);
        student.setStudentId(schoolId);
        if (studentDao.queryByEmail(emailId) != null) {
            return -1;
        }
        if (!studentDao.save(student)) {
            return -2;
        }
        return 0;
    }

    @Override
    public int registerTeacher(String realname, String password, String emailID, String teacherId) {

        Teacher teacher = new Teacher();
        teacher.setName(realname);
        teacher.setPassword(password);
        teacher.setEmailID(emailID);
        teacher.setTeacherId(teacherId);
        if (teacherDao.queryByEmail(emailID) != null) {
            return -1;
        }
        if (!teacherDao.save(teacher)) {
            return -2;
        }
        return 0;
    }

}
