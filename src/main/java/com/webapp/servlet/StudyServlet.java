package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.dao.impl.JobDaoImpl;
import com.webapp.pojo.Study;

import com.webapp.service.StudyService;
import com.webapp.service.impl.StudyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudyServlet")
public class StudyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        JsonObject jsonObject = new JsonObject();

        if (session.getAttribute("id") == null) {
            jsonObject.addProperty("message", "请先登陆");
        } else {
            int userId = (int) session.getAttribute("id");
            String s = request.getParameter("id");
            int courseId = Integer.parseInt(s);
            if (new JobDaoImpl().queryPosterByJobId(courseId).getId() == userId) {
                jsonObject.addProperty("message", "无需申请自己创建的课程");
            } else {
                StudyService applyJobService = new StudyServiceImpl();
                Study study = new Study();
                study.setStudentId(userId);
                study.setCourseId(courseId);
                boolean res = applyJobService.study(study);
                jsonObject.addProperty("message", res ? "申请成功，请耐心等待通过" : "服务器错误");
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
