package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Student;
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
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String userdata = request.getParameter("userdata");
        Gson gson = new Gson();
        Student reqStudent = gson.fromJson(userdata, Student.class);
        reqStudent.setId(id);
        ModifyUserService modifyUserService = new ModifyUserServiceImpl();
        JsonObject jsonObject = new JsonObject();
        if (modifyUserService.modify(reqStudent)) {
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
        int type = Integer.parseInt(request.getParameter("getType"));
        if (type == 1) {
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
        } else if (type == 2) {
            String college = request.getParameter("college");

        }
    }
}
