package com.webapp.servlet;

import com.google.gson.JsonObject;
import com.webapp.service.DeleteJobService;
import com.webapp.service.impl.DeleteJobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModifyJobServlet")
public class DeleteJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int job_id = Integer.parseInt(request.getParameter("job_id"));
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("id");
        JsonObject jsonObject = new JsonObject();

        DeleteJobService deleteJobService = new DeleteJobServiceImpl();
        switch (deleteJobService.delete(job_id, user_id)) {
            case -1:
                jsonObject.addProperty("message", "抱歉，您不是该项目的发起者");
                break;
            case 0:
                jsonObject.addProperty("message", "成功");
                break;
            default:
                jsonObject.addProperty("message", "服务器异常");
        }


        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
