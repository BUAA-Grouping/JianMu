package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.service.DeleteJobService;
import com.webapp.service.impl.DeleteJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "ModifyJobServlet")
public class DeleteJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int job_id = Integer.parseInt(request.getParameter("id"));
        int user_id = -1;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")) {
                user_id = Integer.parseInt(cookie.getValue());
            }
        }
        JsonObject jsonObject = new JsonObject();
        if (user_id == -1) {
            jsonObject.addProperty("message", "用户未登录");
        } else {
            DeleteJobService deleteJobService = new DeleteJobServiceImpl();
            switch (deleteJobService.delete(job_id, user_id)) {
                case -1:
                    jsonObject.addProperty("message", "抱歉，您不是该项目的发起者");
                    break;
                case 0:
                    jsonObject.addProperty("message", "成功");
                    break;
                default:
                    jsonObject.addProperty("message", "服务器异常");
            }
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
