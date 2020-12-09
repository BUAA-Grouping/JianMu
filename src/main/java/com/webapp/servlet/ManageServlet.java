package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Apply;
import com.webapp.pojo.ApplyResponse;
import com.webapp.pojo.Job;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;
import com.webapp.service.impl.SearchJobServiceImpl;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");

        SearchJobService searchJobService = new SearchJobServiceImpl();
        List<ApplyResponse> responses = searchJobService.getApplies(id);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("jobList", gson.toJson(responses));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
