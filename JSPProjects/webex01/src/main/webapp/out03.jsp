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
  out.println("버퍼 초과 처리 : " + out.isAutoFlush() + "<br/>");

  for(int i=1; i<100; i++){
    out.println(i + " : Hello Buffer<br/>");
    if (i % 20 == 0){
      out.println("남은 버퍼 용량 : " + out.getRemaining() + "<br/>");
    }
  }
%>