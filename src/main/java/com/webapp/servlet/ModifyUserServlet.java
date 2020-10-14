package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.dao.UserDao;
import com.webapp.pojo.User;
import com.webapp.service.ModifyUserService;
import com.webapp.service.impl.ModifyUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModifyMemberServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userdata = request.getParameter("userdata");
        Gson gson = new Gson();
        User reqUser = gson.fromJson(userdata, User.class);
        ModifyUserService modifyUserService = new ModifyUserServiceImpl();
        JsonObject jsonObject = new JsonObject();
        if (modifyUserService.modify(reqUser)) {
            jsonObject.addProperty("message", "修改成功");
        } else {
            jsonObject.addProperty("message", "服务器错误");
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("emailID");
        ModifyUserService modifyUserService = new ModifyUserServiceImpl();
        User retUser = modifyUserService.getUser(emailId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        jsonObject.addProperty("userdata", gson.toJson(retUser));
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
