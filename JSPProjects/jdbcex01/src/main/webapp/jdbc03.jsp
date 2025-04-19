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
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
    String url = "jdbc:mysql://localhost:3306/sample";
    String user = "root";
    String password = "victory123";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // html 저장용 참조변수
    StringBuilder sbHtml = new StringBuilder();

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);

        String sql = "select deptno, dname, loc from dept";
        pstmt = conn.prepareStatement(sql);

        rs = pstmt.executeQuery();

        sbHtml.append("<table border='1' cellspacing='0'");

        while (rs.next()){
            sbHtml.append("<tr>");
            String deptno = rs.getString("deptno");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");

            sbHtml.append("<td>" + deptno + "</td>");
            sbHtml.append("<td>" + dname + "</td>");
            sbHtml.append("<td>" + loc + "</td>");
            sbHtml.append("</tr>");
        }
        sbHtml.append("</table>");

    } catch (ClassNotFoundException e){
        System.out.println("[에러] : " + e.getMessage());
    } catch (SQLException e){
        System.out.println("[에러] : " + e.getMessage());
    } finally {
        if(rs != null) rs.close();
        if(pstmt != null) pstmt.close();
        if(conn != null) conn.close();
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%= sbHtml.toString() %>
</body>
</html>
