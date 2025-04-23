<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-23
  Time: 오후 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
입력된 id : <%=id%>
입력된 password : <%=password%>
</body>
</html>
