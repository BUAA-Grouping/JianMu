package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Course;
import com.webapp.pojo.Job;
import com.webapp.pojo.Teacher;
import com.webapp.pojo.User;
import com.webapp.service.SearchCourseService;
import com.webapp.service.SearchJobService;
import com.webapp.service.impl.SearchCourseServiceImpl;
import com.webapp.service.impl.SearchJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CourseDetailServlet")
public class CourseDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        SearchCourseService searchCourseService = new SearchCourseServiceImpl();
        Course job = searchCourseService.getDetail(courseId);
        Teacher teacher = searchCourseService.getTeacher(courseId);
        teacher.setPassword("unknown");

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        jsonObject.addProperty("course", gson.toJson(job));
        jsonObject.addProperty("teacher", gson.toJson(teacher));
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
