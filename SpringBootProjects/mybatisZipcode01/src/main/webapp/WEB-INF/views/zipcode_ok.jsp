<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.mybatis.dto.ZipcodeTO" %>

<%
    ArrayList<ZipcodeTO> lists =  (ArrayList<ZipcodeTO>) request.getAttribute("lists");

    StringBuilder sbHtml = new StringBuilder();

    sbHtml.append("<table border='1' cellspacing='0'>");
    for (ZipcodeTO to : lists){
        sbHtml.append("<tr>");
        sbHtml.append("<td>" + to.getZipcode() + "</td>");
        sbHtml.append("<td>" + to.getSido() + "</td>");
        sbHtml.append("<td>" + to.getGugun() + "</td>");
        sbHtml.append("<td>" + to.getDong() + "</td>");
        sbHtml.append("<td>" + to.getRi() + "</td>");
        sbHtml.append("<td>" + to.getBunji() + "</td>");
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
<%= sbHtml %>
</body>
</html>