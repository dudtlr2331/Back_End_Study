<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>

<%
  Connection conn = null;

  Context initCtx = new InitialContext();
  Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
  DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb1" );

  conn = dataSource.getConnection();
  System.out.println( "데이터베이스 연결성공 : " + conn );

  conn.close();
%>
<html>
<head>
  <title>Title</title>
</head>
<body>

</body>
</html>
