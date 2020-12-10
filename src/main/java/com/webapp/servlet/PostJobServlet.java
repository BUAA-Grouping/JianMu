package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.dao.impl.CourseDaoImpl;
import com.webapp.pojo.Course;
import com.webapp.pojo.Job;
import com.webapp.service.PostJobService;
import com.webapp.service.impl.PostJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PostJobServlet")
public class PostJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        PostJobService postJobService = new PostJobServiceImpl();
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("id");
        String jobdata = (String) request.getParameter("jobdata");
        Job req_job = gson.fromJson(jobdata, Job.class);
        req_job.setProfile(req_job.getProfile().trim());
        String datestr = (String) request.getParameter("expected_end_time");
        SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy");
        Timestamp expectedEndTime;
        Date date = null;
        try {
            date = sf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int courseId;
        try {
            courseId = Integer.parseInt(request.getParameter("courseId"));
        } catch (Exception e) {
            courseId = 0;
        }

        req_job.setCourseId(courseId);

        assert date != null;
        expectedEndTime = new Timestamp(date.getTime());
        JsonObject jsonObject = new JsonObject();
        if (postJobService.post(user_id, req_job, expectedEndTime) && postJobService.createGroup(req_job, user_id)) {
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
        int id = Integer.parseInt(request.getParameter("courseId"));
        String title = new CourseDaoImpl().queryInfoByCourseId(id).getTitle();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("courseTitle", title);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
