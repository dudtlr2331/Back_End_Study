<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-22
  Time: 오후 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String data1 = (String) request.getAttribute("data1");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello form_ok.jsp
<hr/>
data1 : <%=data1%>
</body>
</html>
