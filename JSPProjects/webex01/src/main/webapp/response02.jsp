<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-18
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // 페이지 새로고침
  response.setIntHeader("Refresh", 5);
  out.println(new java.util.Date().toLocaleString());
%>

