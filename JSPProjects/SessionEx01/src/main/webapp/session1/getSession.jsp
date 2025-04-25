<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-25
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // 세션의 상태 확인
  out.println("세션 아이디 : " + session.getId() + "<br/>");
  out.println("세션 유지시간 : " + session.getMaxInactiveInterval() + "<br/>");

  //timestamp
  out.println("세션 생성시간 : " + new java.util.Date(session.getCreationTime()).toLocaleString() + "<br/>");
  out.println("세션 접속시간 : " + new java.util.Date(session.getLastAccessedTime()).toLocaleString() + "<br/>");

  String data1 = (String) session.getAttribute("data1");
  String data2 = (String) session.getAttribute("data2");

  out.println("data1 : " + data1 + "<br/>");
  out.println("data2 : " + data2 + "<br/>");
%>
