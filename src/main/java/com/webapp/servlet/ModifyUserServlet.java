package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.Student;
import com.webapp.pojo.Teacher;
import com.webapp.pojo.User;
import com.webapp.service.UserService;
import com.webapp.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModifyMemberServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        int type = (int) session.getAttribute("type");

        String userdata = request.getParameter("userdata");
        Gson gson = new Gson();
        UserService modifyUserService = new UserServiceImpl();
        JsonObject jsonObject = new JsonObject();

        if (type == 0) {
            Student reqStudent = gson.fromJson(userdata, Student.class);
            reqStudent.setId(id);
            if (modifyUserService.modify(reqStudent)) {
                jsonObject.addProperty("message", "修改成功");
            } else {
                jsonObject.addProperty("message", "服务器错误");
            }
        } else {
            Teacher reqTeacher = gson.fromJson(userdata, Teacher.class);
            reqTeacher.setId(id);
            if (modifyUserService.modify(reqTeacher)) {
                jsonObject.addProperty("message", "修改成功");
            } else {
                jsonObject.addProperty("message", "服务器错误");
            }
        }
        jsonObject.addProperty("type", type);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String emailId = (String) session.getAttribute("emailID");
        UserService userService = new UserServiceImpl();
        User retUser = userService.getUser(emailId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        jsonObject.addProperty("userdata", gson.toJson(retUser));
        writer.write(jsonObject.toString());
        writer.flush();
    }
}
