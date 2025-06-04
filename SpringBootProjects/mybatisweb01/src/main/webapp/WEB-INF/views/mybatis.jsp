<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.mybatis.dto.DeptTO" %>
<%@ page import="java.util.List" %>
<%
    String result = (String) request.getAttribute("result");
    List<DeptTO> resultLists = (List<DeptTO>) request.getAttribute("resultLists");

    StringBuilder sbHtml = new StringBuilder();
    sbHtml.append("<table>");
    for (DeptTO to : resultLists){
        sbHtml.append("<tr>");
        sbHtml.append("<td>" + to.getDeptno() + "</td>");
        sbHtml.append("<td>" + to.getDname() + "</td>");
        sbHtml.append("<td>" + to.getLoc() + "</td>");
        sbHtml.append("</tr>");
    }
    sbHtml.append("</table>");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

mybatis.jsp
<br/><hr/>

result : <%=result%>
<br/><hr/>

resultList : <%=sbHtml%>

</body>
</html>