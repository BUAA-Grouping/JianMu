package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.User;
import com.webapp.service.SignService;
import com.webapp.service.impl.SignServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    SignService signService = new SignServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailID = request.getParameter("emailID");
        String password = request.getParameter("password");
        SignService signService = new SignServiceImpl();
        JsonObject jsonObject = new JsonObject();
        System.out.println("emailID: " + emailID + " password: " + password);
        switch (signService.signIn(emailID, password)) {
            case -1:
                jsonObject.addProperty("message", "用户名不存在");
                break;
            case -2:
                jsonObject.addProperty("message", "用户名或密码错误");
                break;
            case 0:
                jsonObject.addProperty("message", "登陆成功");
            default:
                jsonObject.addProperty("message", "服务器异常");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        System.out.println(jsonObject.toString());////
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
