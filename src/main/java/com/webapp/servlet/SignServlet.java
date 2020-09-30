package com.webapp.servlet;

import com.google.gson.Gson;
import com.webapp.pojo.TestUser;
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
public class SignServlet extends HttpServlet {
    SignService signService = new SignServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String action = request.getParameter("task");
//        if (action.equals("sign in")) {
//            if (signService.signIn(new User(username, password)) == null) {
//                //TODO where to Jump
//                System.out.println(username + "sign in" + System.currentTimeMillis());
//                request.getRequestDispatcher("./").forward(request, response);
//            } else {
//                //TODO how to respon
//            }
//        } else if (action.equals("sign up")) {
//            if (signService.existUser(username)) {
//                //TODO how to respon
//                request.getRequestDispatcher("./").forward(request, response);
//            } else {
//                signService.registUser(new User(username, password));
//            }
//        } else {
//
//        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get Request");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        TestUser u1 = new TestUser("Amadeus", 21, false);
        TestUser u2 = new TestUser("TwoBeNo.0", 12, true);
        ArrayList<TestUser> arrayList= new ArrayList<>();
        arrayList.add(u1);
        arrayList.add(u2);
        Gson gson = new Gson();
        String data = gson.toJson(arrayList);
        out.print(data);
        out.flush();
        out.close();
    }
}
