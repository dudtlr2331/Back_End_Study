<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2025-04-17
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="org.example.model1.BoardTO" %>
<%@ page import="org.example.model1.BoardDAO" %>

<%
	BoardTO to = new BoardTO();
	to.setSeq( request.getParameter( "seq" ) );
	to.setSubject( request.getParameter( "subject" ) );
	to.setMail( "" );
	if ( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) ) {
		to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
	}
	to.setPassword( request.getParameter( "password" ) );
	to.setContent( request.getParameter( "content" ) );

	BoardDAO dao = new BoardDAO();
	int flag = dao.boardModifyOk( to );

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println( "alert( '글수정 성공' );" );
		out.println( "location.href = 'board_view1.jsp?seq=" + to.getSeq() + "';" );
	} else if ( flag == 1 ) {
		out.println( "alert( '비밀번호 오류' );" );
		out.println( "history.back();" );
	} else {
		out.println( "alert( '글수정 실패' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>" );
%>
