<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String data1 = (String) request.getAttribute("data1");
    String data2 = (String) request.getAttribute("data2");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    form_ok.jsp
    <br/><hr/>

    <%= data1 %>
    <br/>
    <%= data2 %>

    <hr/>

    jstl<br/>
    ${data1}<br/>
    ${data2}

</body>
</html>