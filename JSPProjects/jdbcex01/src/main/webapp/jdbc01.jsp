<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<%
  String url = "jdbc:mysql://localhost:3306/sample";
  String user = "root";
  String password = "victory123";

  Connection conn = null;
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);

    System.out.println("데이터베이스 연결 성공");
    conn.close();
%>
</body>
</html>
