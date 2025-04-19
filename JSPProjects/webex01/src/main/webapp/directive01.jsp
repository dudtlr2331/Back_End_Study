<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 현재 날짜
//    java.util.Date date = new java.util.Date();
    Date date = new Date();
    out.println(date.toLocaleString());
%>
</body>
</html>
