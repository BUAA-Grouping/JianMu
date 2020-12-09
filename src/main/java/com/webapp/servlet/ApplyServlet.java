package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.pojo.User;
import com.webapp.service.ApplyJobService;
import com.webapp.service.impl.ApplyJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet")
public class ApplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("id");
        int jobId = (int) request.getAttribute("id");
        ApplyJobService applyJobService = new ApplyJobServiceImpl();

        JsonObject jsonObject = new JsonObject();

        List<Apply> users = applyJobService.query(jobId);
        for (User user : users) {
            if (user.getId() == userId) {
            }
        }

        boolean res = applyJobService.apply(jobId, userId);

        jsonObject.addProperty("message", res ? "申请成功，请耐心等待通过" : "服务器错误");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
