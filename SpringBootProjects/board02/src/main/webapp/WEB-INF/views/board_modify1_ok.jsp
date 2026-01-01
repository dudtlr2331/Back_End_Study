<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	String seq = (String)request.getAttribute( "seq" );
	int flag = (Integer)request.getAttribute( "flag" );

	out.println( "<script type='text/javascript'>" );
	if ( flag == 0 ) {
		out.println( "alert( '글수정 성공' );" );
		out.println( "location.href = './view.do?seq=" + seq + "';" );
	} else if ( flag == 1 ) {
		out.println( "alert( '비밀번호 오류' );" );
		out.println( "history.back();" );
	} else {
		out.println( "alert( '글수정 실패' );" );
		out.println( "history.back();" );
	}
	out.println( "</script>" );
%>
