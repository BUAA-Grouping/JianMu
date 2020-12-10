package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Course;
import com.webapp.service.PostCourseService;
import com.webapp.service.impl.PostCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PostCourseServlet")
public class PostCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        int id = (int) request.getSession().getAttribute("id");
        String s = request.getParameter("courseData");
        Course course = gson.fromJson(s, Course.class);
        PostCourseService postCourseService = new PostCourseServiceImpl();
        JsonObject jsonObject = new JsonObject();

        if (postCourseService.post(id, course)) {
            jsonObject.addProperty("message", "发布成功");
        } else {
            jsonObject.addProperty("message", "服务器错误");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
