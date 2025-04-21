<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-21
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="to" class="org.example.model.MemberTO" />
<jsp:setProperty name="to" property="id" value="tester1"/> <%--to.setId("tseter1");--%>
<jsp:setProperty name="to" property="password" value="123456"/>  <%-- to.setPassword("123456"); 액션 태그를 사용해서 set을 했다.--%>

<%
    out.println("id : " + to.getId() + "<br/>");
    out.println("password : " + to.getPassword() + "<br/>");
%>
