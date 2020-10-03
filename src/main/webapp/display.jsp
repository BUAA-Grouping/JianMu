<%@ page import="com.webapp.pojo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: amadeus
  Date: 2020/9/29
  Time: 上午12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    User[] user = (User[]) session1.getAttribute("list");
    //do something "userlist"
%>
<%
    for (int i = 0; i < user.length; i++) {
%>
<p><%=user[i].getUsername()%>
</p>
<p><%=user[i].getPassword()%>
</p>
<%}%>
</body>
</html>
