package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.service.SignService;
import com.webapp.service.impl.SignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realname = request.getParameter("realname");
        String schoolId = request.getParameter("schoolID");
        String emailID = request.getParameter("emailID");
        String password = request.getParameter("password");
        SignService signService = new SignServiceImpl();
        JsonObject jsonObject = new JsonObject();
        switch (signService.registerUser(realname, password, emailID, Integer.parseInt(schoolId))) {
            case 0:
                jsonObject.addProperty("message", "注册成功");
                break;
            case -1:
                jsonObject.addProperty("message", "用户名已存在");
                break;
            default:
                jsonObject.addProperty("message", "服务器异常");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
