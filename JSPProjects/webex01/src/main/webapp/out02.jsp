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
  out.println("설정 버퍼 크기 : " + out.getBufferSize() + "<br/>");

  out.println("남은 버퍼 크기 : " + out.getRemaining() + "<br/>");
  out.println("Hello Buffer<br/>");
  out.println("Hello Buffer<br/>");
  out.println("Hello Buffer<br/>");
  out.println("Hello Buffer<br/>");
  out.println("Hello Buffer<br/>");

  out.println("남은 버퍼 크기 : " + out.getRemaining() + "<br/>");

  out.println("버퍼 초과 처리 : " + out.isAutoFlush() + "<br/>");

%>