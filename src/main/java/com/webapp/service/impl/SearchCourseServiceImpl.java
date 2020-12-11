package com.webapp.service.impl;

import com.webapp.dao.CourseDao;
import com.webapp.dao.JobDao;
import com.webapp.dao.UserDao;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.dao.impl.StudentDaoImpl;
import com.webapp.pojo.*;
import com.webapp.service.SearchCourseService;

import java.util.ArrayList;
import java.util.List;

public class SearchCourseServiceImpl implements SearchCourseService {
    CourseDao courseDao = new CourseDaoImpl();
    JobDao jobDao = new JobDaoImpl();
    UserDao studentDao = new StudentDaoImpl();

    @Override
    public int searchCourse(String keyword, int college, String teacher, ArrayList<Course> courseList, List<Teacher> teachers) {
        courseList.addAll(courseDao.queryCoursesByConditions(keyword, teacher, college));
        for (Course c : courseList) {
            teachers.add(courseDao.queryTeachersByCourseId(c.getId()).get(0));
        }
        if (courseList.isEmpty()) {
            return -1;
        }
        return 0;
    }

    @Override
    public void getDetail(int courseId, Course course, Teacher teacher, List<Job> jobList, List<List<User>> studentList) {
        Course course1 = courseDao.queryInfoByCourseId(courseId);
        course.setId(course1.getId());
        course.setTitle(course1.getTitle());
        course.setCollege(course1.getId());
        course.setProfile(course1.getProfile());
        course.setCreateAt(course1.getCreateAt());
        course.setCapacity(course1.getCapacity());
        Teacher teacher1 = courseDao.queryTeachersByCourseId(courseId).get(0);
        teacher.setTeacherId(teacher1.getTeacherId());
        teacher.setTitle(teacher1.getTitle());
        teacher.setId(teacher1.getId());
        teacher.setEmailID(teacher1.getEmailID());
        teacher.setName(teacher1.getName());
        teacher.setCampus(teacher1.getCampus());
        jobList.addAll(jobDao.queryJobsByCourseId(courseId));
        for (Job j : jobList) {
            List<User> students = new ArrayList<>();
            students.add(jobDao.queryPosterByJobId(j.getId()));
            List<Apply> applies = jobDao.queryApplies(j.getId());
            for (Apply apply : applies) {
                if (apply.getStatus() == 2) {
                    students.add(studentDao.queryInfoById(apply.getUserId()));
                }
            }
            studentList.add(students);
        }
    }

    @Override
    public Teacher getTeacher(int courseId) {
        return courseDao.queryTeachersByCourseId(courseId).get(0);
    }



    @Override
    public boolean getCourse(int teacherId, List<Course> courseList, List<List<User>> studentList) {
        courseList.addAll(courseDao.queryTaughtCourses(teacherId));
        for (Course course : courseList) {
            List<User> list = new ArrayList<>();
            List<Study> studies = courseDao.queryStudies(course.getId());
            for (Study study : studies) {
                list.add(studentDao.queryInfoById(study.getStudentId()));
            }
            studentList.add(list);
        }
        return true;
    }
}
