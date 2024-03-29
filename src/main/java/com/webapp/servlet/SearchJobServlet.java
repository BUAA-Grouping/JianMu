package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Job;
import com.webapp.pojo.JobsSearchResponse;
import com.webapp.pojo.User;
import com.webapp.service.SearchJobService;
import com.webapp.service.impl.SearchJobServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchJobServlet")
public class SearchJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        int college;
        try {
            college = Integer.parseInt(request.getParameter("college"));
        } catch (Exception e) {
            college = 0;
        }
        int campus;
        try {
            campus = Integer.parseInt(request.getParameter("campus"));
        } catch (Exception e) {
            campus = 0;
        }
        ArrayList<Job> jobList = new ArrayList<>();
        List<User> poster = new ArrayList<>();
        List<Timestamp> expected_end_time = new ArrayList<>();
        SearchJobService searchJobService = new SearchJobServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        JsonObject jsonObject = new JsonObject();
        
        int userId;
        try {
            userId = (int) request.getSession().getAttribute("id");
        } catch (Exception e) {
            userId = 0;
        }

        switch (searchJobService.searchJob(keyword, college, campus, jobList, poster, expected_end_time, userId)) {
            case -1:
                jsonObject.addProperty("message", "没有符合条件的项目");
                writer.write(jsonObject.toString());
                writer.flush();
                break;
            case 0:
                JobsSearchResponse jobsSearchResponse = new JobsSearchResponse(jobList, poster, expected_end_time);
                writer.write(new Gson().toJson(jobsSearchResponse));
                writer.flush();
                break;
            default:
                jsonObject.addProperty("message", "服务器错误");
                writer.write(jsonObject.toString());
                writer.flush();
        }
    }
}
