<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-17
  Time: 오전 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
  String strDong = request.getParameter( "dong" );
  // System.out.println( strDong );

  String url = "jdbc:mysql://localhost:3306/project";
  String user = "project";
  String password = "123456";

  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  // html 저장용 참조변수
  StringBuilder sbHtml = new StringBuilder();

  try {
    Class.forName( "com.mysql.cj.jdbc.Driver" );
    conn = DriverManager.getConnection( url, user, password );

    String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
    pstmt = conn.prepareStatement( sql );
    pstmt.setString( 1, strDong + "%" );

    rs = pstmt.executeQuery();

    sbHtml.append( "<table border='1' cellspacing='0'>" );
    while ( rs.next() ) {
      String zipcode = rs.getString( "zipcode" );
      String sido = rs.getString( "sido" );
      String gugun = rs.getString( "gugun" );
      String dong = rs.getString( "dong" );
      String ri = rs.getString( "ri" );
      String bunji = rs.getString( "bunji" );

      //System.out.println( zipcode );

      sbHtml.append( "<tr>" );
      sbHtml.append( "<td>" + zipcode + "</td>" );
      sbHtml.append( "<td>" + sido + "</td>" );
      sbHtml.append( "<td>" + gugun + "</td>" );
      sbHtml.append( "<td>" + dong + "</td>" );
      sbHtml.append( "<td>" + ri + "</td>" );
      sbHtml.append( "<td>" + bunji + "</td>" );
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

<%=sbHtml.toString() %>

</body>
</html>
