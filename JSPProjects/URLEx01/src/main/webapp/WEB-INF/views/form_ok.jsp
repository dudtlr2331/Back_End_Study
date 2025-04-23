<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-23
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String data1 = (String) request.getAttribute("data1");
  String data2 = (String) request.getAttribute("data2");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=data1%>
<%=data2%>
</body>
</html>
