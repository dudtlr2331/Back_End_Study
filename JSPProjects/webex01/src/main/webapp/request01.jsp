<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 클라이언트의 아이피 (IPv6 -> v4)
    out.println(request.getRemoteAddr() + "<br/>");
    // 요청 경로
    out.println(request.getContextPath() + "<br/>");
    out.println(request.getRequestURI() + "<br/>");
    out.println(request.getRequestURL() + "<br/>");

    //
    out.println(request.getServerName() + "<br/>");
    out.println(request.getServerPort() + "<br/>");
%>
</body>
</html>
