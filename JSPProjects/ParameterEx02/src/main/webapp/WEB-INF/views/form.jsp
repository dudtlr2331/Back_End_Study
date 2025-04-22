<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-22
  Time: 오후 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello form.jsp

<hr/>
<form action="./controller" method="get">
    <input type="hidden" name="path" value="form_ok">
    data1 <input type="text" name="data1">
    <input type="submit" value="Get 방식">
</form>

<form action="./controller" method="post">
    <input type="hidden" name="path" value="form_ok">
    data1 <input type="text" name="data1">
    <input type="submit" value="Post 방식">
</form>
</body>
</html>
