<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.example.model1.BoardTO" %>

<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if(flag == 0){
		out.println("alert('글쓰기 성공');");
		out.println("location.href = 'list.emot';");
	} else {
		out.println("글쓰기 실패");
		out.println("history.back();");
	}
	out.println("</script>");
%>