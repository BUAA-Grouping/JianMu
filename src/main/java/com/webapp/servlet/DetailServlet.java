package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Job;
import com.webapp.service.SearchJobService;
import com.webapp.service.impl.SearchJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DetailServlet")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        SearchJobService searchJobService = new SearchJobServiceImpl();
        Job job = searchJobService.getDetail(jobId);

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        jsonObject.addProperty("userdata", gson.toJson(job));
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
