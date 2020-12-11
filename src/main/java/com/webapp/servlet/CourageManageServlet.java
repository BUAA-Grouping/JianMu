package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Course;
import com.webapp.pojo.User;
import com.webapp.service.SearchCourseService;
import com.webapp.service.impl.SearchCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ManageServlet")
public class CourageManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) request.getSession().getAttribute("id");
        SearchCourseService service = new SearchCourseServiceImpl();
        List<Course> courseList = new ArrayList<>();
        List<List<User>> studentList = new ArrayList<>();
        service.getCourse(id, courseList, studentList);
        JsonObject jsonObject = new JsonObject();
        Gson gson = new Gson();
        jsonObject.addProperty("courseList", gson.toJson(courseList));
        jsonObject.addProperty("studentList", gson.toJson(studentList));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
