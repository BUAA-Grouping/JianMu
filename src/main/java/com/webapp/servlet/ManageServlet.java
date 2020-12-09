package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Apply;
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
import java.util.List;

@WebServlet(name = "ManageServlet")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        SearchJobService searchJobService = new SearchJobServiceImpl();
        User poster = searchJobService.getPoster(jobId);
        HttpSession session = request.getSession();
        Object id = session.getAttribute("id");
        JsonObject jsonObject = new JsonObject();
        if (id == null || (int) id != poster.getId()) {
            jsonObject.addProperty("message", "登陆该项目的管理员账号查看申请");
        } else {
            jsonObject.addProperty("message", "当前申请如下");
            Gson gson = new Gson();
            List<Apply> applies = searchJobService.getApplies(jobId);
            jsonObject.addProperty("applies", gson.toJson(applies));
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
