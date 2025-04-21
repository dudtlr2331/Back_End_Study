<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-21
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="to" class="org.example.model.MemberTO" /> <%-- import와 new() 한번에 해준다.--%>
<%
    to.setId("tseter1");
    to.setPassword("123456");

    out.println("id : " + to.getId() + "<br/>");
    out.println("password : " + to.getPassword() + "<br/>");
%>
