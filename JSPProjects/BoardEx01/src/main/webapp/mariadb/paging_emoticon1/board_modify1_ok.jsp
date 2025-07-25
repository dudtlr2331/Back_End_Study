﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%
	String cpage = request.getParameter("cpage");
	String seq = request.getParameter("seq");
	String subject = request.getParameter("subject");
	String mail = "";
	if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")){
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}
	String content = request.getParameter("content");
	String emot = request.getParameter("emot");
	String password = request.getParameter("password");

	Connection conn = null;
	PreparedStatement pstmt = null;

	// 정상 : 0 / 비밀번호 오류 : 1 / 시스템 오류 : 2
	int flag = 2;

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mysql1" );

		conn = dataSource.getConnection();

		String sql = "update emot_board1 set subject = ?, mail = ?, content = ?, emot = ? where seq = ? and password = md5(?)";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, subject);
		pstmt.setString(2, mail);
		pstmt.setString(3, content);
		pstmt.setString(4, emot);
		pstmt.setString(5, seq);
		pstmt.setString(6, password);

		int result = pstmt.executeUpdate();
		if (result == 0){
			//번호나 비밀번호 오류
			flag = 1;
		} else if (result == 1){
			// 정상
			flag = 0;
		}
	} catch ( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch ( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}

	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('글수정 성공');");
		out.println("location.href = 'board_view1.jsp?cpage="+ cpage + "&seq=" + seq + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('글수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>