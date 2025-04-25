<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-25
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 세션 저장
    session.setAttribute("data1", "value1");
    session.setAttribute("data2", "value2");

    out.println("저장 완료");
%>
