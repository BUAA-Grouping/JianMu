package com.webapp.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webapp.pojo.User;
import com.webapp.service.SignService;
import com.webapp.service.impl.SignServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    SignService signService = new SignServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        JsonObject jsonObject = new JsonObject();

        HttpSession session = request.getSession();
        Object s = session.getAttribute("username");
        if (s != null) {
            jsonObject.addProperty("message", "登陆成功");
            jsonObject.addProperty("username", (String) s);
        } else {
            String emailID = request.getParameter("emailID");
            String password = request.getParameter("password");
            SignService signService = new SignServiceImpl();

            boolean success = false;
            User user = new User();
            switch (signService.signIn(emailID, password, user)) {
                case -1:
                    jsonObject.addProperty("message", "用户名不存在");
                    break;
                case -2:
                    jsonObject.addProperty("message", "用户名或密码错误");
                    break;
                case 0:
                    jsonObject.addProperty("message", "登陆成功");
                    jsonObject.addProperty("username", user.getName());
                    success = true;
                    break;
                default:
                    jsonObject.addProperty("message", "服务器异常");
            }
            if (success) {
                session.setAttribute("username", user.getName());
                session.setAttribute("emailID", emailID);
                session.setAttribute("password", user.getPassword());
                session.setAttribute("id",user.getId());
            }
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }
}