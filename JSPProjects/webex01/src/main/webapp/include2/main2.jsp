<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-18
  Time: 오후 4:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- ./include1/main1.jsp --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int i = 10;
%>

Hello JSP 1 <br/>
Hello JSP 2 <br/>

<jsp:include page="sub1.jsp"></jsp:include>

</body>
</html>
