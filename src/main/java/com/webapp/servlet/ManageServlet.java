package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Apply;
import com.webapp.pojo.ApplyResponse;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;
import com.webapp.service.UserService;
import com.webapp.service.impl.SearchJobServiceImpl;
import com.webapp.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

@WebServlet(name = "ManageServlet")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int status = Integer.parseInt(request.getParameter("status"));
        SearchJobService searchJobService = new SearchJobServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        JsonObject jsonObject = new JsonObject();
        if (searchJobService.reply(userId, jobId, status) && (status != 2 || userService.join(userId, jobId))) {
            jsonObject.addProperty("message", "处理已提交");
        } else {
            jsonObject.addProperty("message", "服务器错误");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");

        SearchJobService searchJobService = new SearchJobServiceImpl();
        List<List<ApplyResponse>> responses = searchJobService.getApplies(id);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("jobList", gson.toJson(responses));

        UserService userService = new UserServiceImpl();
        List<Apply> myApply = userService.getApplies(id);
        jsonObject.addProperty("myApply", gson.toJson(myApply));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
