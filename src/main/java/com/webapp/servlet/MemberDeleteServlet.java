package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.service.MemberDeleteService;
import com.webapp.service.impl.MemberDeleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        MemberDeleteService memberDeleteService = new MemberDeleteServiceImpl();

        JsonObject jsonObject = new JsonObject();
        if (memberDeleteService.delete(studentId, courseId)) {
            jsonObject.addProperty("message", "删除成功");
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
