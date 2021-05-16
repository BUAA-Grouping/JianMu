package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.JobInfoMap;
import com.webapp.pojo.User;
import com.webapp.service.UserService;
import com.webapp.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl();
        User retUser = userService.getUserByUserId(userId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        jsonObject.addProperty("userdata", gson.toJson(retUser));
        jsonObject.addProperty("college", JobInfoMap.college_map.get(retUser.getCollegeId()));
        jsonObject.addProperty("campus", JobInfoMap.campus_map.get(retUser.getCampus()));
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
