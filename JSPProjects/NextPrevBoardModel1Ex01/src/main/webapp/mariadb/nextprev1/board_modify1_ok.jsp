<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-24
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int flag = (Integer) request.getAttribute("flag");
    String seq = (String) request.getAttribute("seq");

    out.println("<script type='text/javascript'>");
    if(flag == 0) {
        out.println("alert('글수정 성공');");
        out.println("location.href = 'view.do?seq=" + seq + "';");
    } else if (flag == 1) {
        out.println("alert('비밀번호 오류');");
        out.println("history.back();");
    } else {
        out.println("alert('글수정 실패');");
        out.println("history.back();");
    }
    out.println("</script>");
%>