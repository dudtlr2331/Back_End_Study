<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	int flag = (Integer)request.getAttribute( "flag" );

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println( "alert( '글쓰기 성공' );" );
		out.println( "location.href = './list.do';" );
	} else {
		out.println( "alert( '글쓰기 실패' );" );
		out.println( "history.back();" );
	}
    out.println( "</script>" );
%>




