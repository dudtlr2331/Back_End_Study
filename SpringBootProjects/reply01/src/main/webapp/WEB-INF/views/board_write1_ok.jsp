<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2025-04-17
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	int flag = (Integer) request.getAttribute("flag");
	String cpage = (String) request.getAttribute("cpage");

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println( "alert( '글쓰기 성공' );" );
		out.println( "location.href = 'list.do';" );
	} else {
		out.println( "alert( '글쓰기 실패' );" );
		out.println( "history.back();" );
	}
    out.println( "</script>" );
%>




