package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.mysql.cj.Session;
import com.webapp.service.DeleteUserService;
import com.webapp.service.impl.DeleteUserServiceImpl;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession(false);
        String emailId = (String) session.getAttribute("emailID");
        JsonObject jsonObject = new JsonObject();
        if (emailId != null) {
            DeleteUserService deleteUserService = new DeleteUserServiceImpl();
            if (deleteUserService.deleteUser(emailId) != 0) {
                jsonObject.addProperty("message", "服务器错误");
            } else {
                jsonObject.addProperty("message", "成功删除");
                session.removeAttribute("emailID");
                session.removeAttribute("password");
                session.removeAttribute("username");
            }
        } else {
            jsonObject.addProperty("message", "服务器错误");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }
}
