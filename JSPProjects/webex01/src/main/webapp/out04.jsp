<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-18
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="1kb" %>
<%
  out.println( "1 <br />" );
  out.println( "2 <br />" );
  out.println( "3 <br />" );

  // 버퍼 내용 제거
  out.clearBuffer();
  out.println( "남은 버퍼 크기 : " +  out.getRemaining() + "<br />" );

  out.println( "4 <br />" );
  out.println( "5 <br />" );
  out.println( "6 <br />" );

  // 클라이언트에 전송하고 버퍼 비우기
  out.flush();
  out.println( "남은 버퍼 크기 : " +  out.getRemaining() + "<br />" );

  out.println( "7 <br />" );
  out.println( "8 <br />" );

  // jsp 강제 종료
  out.close();

  out.println( "9 <br />" );
  out.println( "10 <br />" );
%>