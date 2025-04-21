<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	String wip = request.getRemoteAddr();

	BoardDAO dao = new BoardDAO();
	int flag = dao.boardWriteOk(to);

	out.println("<script type='text/javascript'>");
	if(flag == 0){
		out.println("alert('글쓰기 성공');");
		out.println("location.href = 'board_list1.jsp';");
	} else {
		out.println("글쓰기 실패");
		out.println("history.back();");
	}
	out.println("</script>");
%>