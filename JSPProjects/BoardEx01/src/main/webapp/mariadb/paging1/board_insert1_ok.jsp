<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%
	// board_insert1_ok.jsp
	// 100개의 더미 데이터 입력

	Connection conn = null;
	PreparedStatement pstmt = null;

	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mysql1");

		conn = dataSource.getConnection();

		String sql = "insert into board1 values(0, ?, ?, ?, md5(?), ?, 0, ?, now());";
		pstmt = conn.prepareStatement( sql );

		for (int i = 1; i <= 100; i++){
			pstmt.setString( 1, "제목" + i );
			pstmt.setString( 2, "이름" );
			pstmt.setString( 3, "tester@test.com" );
			pstmt.setString( 4, "1234" );
			pstmt.setString( 5, "내용" + i );
			pstmt.setString( 6, "000.000.000.000" );

			pstmt.executeUpdate();

		}

	} catch (NamingException e){
		System.out.println("[에러] : " + e.getMessage());
	} catch (SQLException e){
		System.out.println("[에러] : " + e.getMessage());
	} finally {
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}

	out.println("<script type='text/javascript'>");
	out.println("alert('데이터 입력 성공');");
	out.println("location.href = 'board_list1.jsp';");
	out.println("</script>");
%>