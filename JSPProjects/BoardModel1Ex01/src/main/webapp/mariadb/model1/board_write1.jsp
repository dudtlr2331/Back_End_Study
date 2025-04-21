﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%@ page import="org.example.model1.BoardTO" %>
<%@ page import="org.example.model1.BoardDAO" %>

<%
	BoardTO to = new BoardTO();
	to.setSubject( request.getParameter( "subject" ) );
	to.setWriter( request.getParameter( "writer" ) );

	to.setMail( "" );
	if ( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) ) {
		to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
	}

	to.setPassword( request.getParameter( "password" ) );
	to.setContent( request.getParameter( "content" ) );

	to.setWip( request.getRemoteAddr() );

	BoardDAO dao = new BoardDAO();
	int flag = dao.boardWriteOk( to );

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println( "alert( '글쓰기 성공' );" );
		out.println( "location.href = 'board_list1.jsp';" );
	} else {
		out.println( "alert( '글쓰기 실패' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>" );
%>