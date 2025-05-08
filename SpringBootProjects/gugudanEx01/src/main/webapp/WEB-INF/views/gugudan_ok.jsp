<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    int startDan = (int) request.getAttribute("startDan");
    int endDan = (int) request.getAttribute("endDan");

    for (int i = startDan; i <= endDan; i++){
        for(int j = 1; j <= 9; j++){
            System.out.printf("%d X %d = %d", startDan, j, (startDan*j));
        }
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>