<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2025-04-17
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%
	String seq = request.getParameter( "seq" );
	String password = request.getParameter( "password" );

	//System.out.println( seq );
	//System.out.println( password );

	Connection conn = null;
	PreparedStatement pstmt = null;

	// 정상 : 0 / 비밀번호 오류 : 1 / 시스템 오류 : 2
	int flag = 2;

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mysql1" );

		conn = dataSource.getConnection();

		String sql = "delete from board1 where seq=? and password = md5( ? )";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString( 1, seq );
		pstmt.setString( 2, password );

		int result = pstmt.executeUpdate();
		if ( result == 0 ) {
			// 번호나 비밀번호 오류
			flag = 1;
		} else if ( result == 1 ) {
			// 정상
			flag = 0;
		}
	} catch( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println("alert( '글삭제 성공' );");
		out.println("location.href = 'board_list1.jsp';");
	} else if ( flag == 1 ) {
		out.println( "alert( '비밀번호 오류' );" );
		out.println( "history.back();" );
	} else {
		out.println( "alert( '글삭제 실패' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>" );
%>