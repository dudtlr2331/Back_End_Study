<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-21
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String code = request.getParameter("code");
    String path = "sub4.jsp";
    if(code.equals("a")){
        path = "sub1.jsp";
    } else if (code.equals("b")) {
        path = "sub2.jsp";
    } else if (code.equals("c")) {
        path = "sub3.jsp";
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

view 시작 <br />

<jsp:forward page="<%=path%>"></jsp:forward>

view 끝 <br/>
</body>
</html>
