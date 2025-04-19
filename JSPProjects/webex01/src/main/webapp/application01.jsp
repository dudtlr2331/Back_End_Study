<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-18
  Time: 오후 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // tomcat
  out.println(application.getServerInfo() + "<br/>");

  // jsp
  out.println(application.getMajorVersion() + "<br/>");
  out.println(application.getMajorVersion() + "<br/>");

  // jsp 경로
  out.println(application.getRealPath(".") + "<br/>");

%>