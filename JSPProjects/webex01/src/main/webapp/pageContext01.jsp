<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-18
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // pageContext - 기본 객체 구하기
  out.println("Hello JSP<br/>");

  JspWriter writer = pageContext.getOut();
  writer.println("Hello JSP2<br/>");

  out.println(out + "<br/>");
  out.println(writer + "<br/>");
%>
