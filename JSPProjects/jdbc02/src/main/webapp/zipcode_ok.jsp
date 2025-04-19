<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%
  String strDong = request.getParameter( "dong" );

  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  StringBuilder sbHtml = new StringBuilder();

  try {
    Context initCtx = new InitialContext();
    Context envCtx = (Context) initCtx.lookup("java:comp/env");
    DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mysql2");

    conn = dataSource.getConnection();

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

  } catch (NamingException e){
    System.out.println("[에러] : " + e.getMessage());
  } catch (SQLException e){
    System.out.println("[에러] : " + e.getMessage());
  } finally {
    if (conn != null) conn.close();
    if (pstmt != null) pstmt.close();
    if (rs != null) rs.close();
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