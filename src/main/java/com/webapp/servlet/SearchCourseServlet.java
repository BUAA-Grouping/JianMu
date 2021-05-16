package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.*;
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

@WebServlet(name = "SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        int college;
        try {
            college = Integer.parseInt(request.getParameter("college"));
        } catch (Exception e) {
            college = 0;
        }
        String teacher;
        try {
            teacher = request.getParameter("teacher");
        } catch (Exception e) {
            teacher = null;
        }
        ArrayList<Course> courseList = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        SearchCourseService searchCourseService = new SearchCourseServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        JsonObject jsonObject = new JsonObject();
        switch (searchCourseService.searchCourse(keyword, college, teacher, courseList, teachers)) {
            case -1:
                jsonObject.addProperty("message", "没有符合条件的课程");
                writer.write(jsonObject.toString());
                writer.flush();
                break;
            case 0: {
                Gson gson = new Gson();
                jsonObject.addProperty("courseList", gson.toJson(courseList));
                jsonObject.addProperty("teacherList", gson.toJson(teachers));
                writer.write(jsonObject.toString());
                writer.flush();
                break;
            }
            default:
                jsonObject.addProperty("message", "服务器错误");
                writer.write(jsonObject.toString());
                writer.flush();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
