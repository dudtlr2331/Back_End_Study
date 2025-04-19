<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-17
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
    String strEname = request.getParameter( "ename" );

    String url = "jdbc:mysql://localhost:3306/sample";
    String user = "root";
    String password = "victory123";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    StringBuilder sbHtml = new StringBuilder();

    try {
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        conn = DriverManager.getConnection( url, user, password );

        String sql = "select empno, ename, job, mgr, hiredate,  sal, comm, deptno from emp where ename = ?";
        pstmt = conn.prepareStatement( sql );
        pstmt.setString( 1, strEname);

        rs = pstmt.executeQuery();

        sbHtml.append( "<table border='1' cellspacing='0'>" );
        while ( rs.next() ) {
            int empno = rs.getInt( "empno" );
            String ename = rs.getString( "ename" );
            String job = rs.getString( "job" );
            int mgr = rs.getInt( "mgr" );
            String hiredate = rs.getString( "hiredate" );
            String sal = rs.getString( "sal" );
            String comm = rs.getString( "comm" );
            int deptno = rs.getInt( "deptno" );

            //System.out.println( zipcode );

            sbHtml.append( "<tr>" );
            sbHtml.append( "<td>" + empno + "</td>" );
            sbHtml.append( "<td>" + ename + "</td>" );
            sbHtml.append( "<td>" + job + "</td>" );
            sbHtml.append( "<td>" + mgr + "</td>" );
            sbHtml.append( "<td>" + hiredate + "</td>" );
            sbHtml.append( "<td>" + sal + "</td>" );
            sbHtml.append( "<td>" + comm + "</td>" );
            sbHtml.append( "<td>" + deptno + "</td>" );
            sbHtml.append( "</tr>" );

        }
        sbHtml.append( "</table>" );

    } catch ( ClassNotFoundException e ) {
        System.out.println( "[에러] " + e.getMessage() );
    } catch ( SQLException e ) {
        System.out.println( "[에러] " + e.getMessage() );
    } finally {
        if ( rs != null ) rs.close();
        if ( pstmt != null ) pstmt.close();
        if ( conn != null ) conn.close();
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
