package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.service.DeleteUserService;
import com.webapp.service.impl.DeleteUserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

public class DeleteUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String emailID = request.getParameter("emailID");
        String password = request.getParameter("password");
        DeleteUserService deleteUserService = new DeleteUserServiceImpl();
        JsonObject jsonObject = new JsonObject();
        switch (deleteUserService.deleteUser(emailID, password)) {
            case -1:
                jsonObject.addProperty("message", "用户名不存在");
                break;
            case -2:
                jsonObject.addProperty("message", "用户名或密码错误");
                break;
            case -3:
                jsonObject.addProperty("message", "成功删除");
                break;
            default:
                jsonObject.addProperty("message", "服务器错误");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
