<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

form.jsp

<br/><hr/>

<form action="/form_ok.do" method="post">
    data1 <input type="text" name="data1"/>
    /
    data2 <input type="text" name="data2"/>
    &nbsp;&nbsp;
    <input type="submit" value="Post방식 전송"/>
</form>

<form action="/form_ok.do" method="get">
    data1 <input type="text" name="data1"/>
    /
    data2 <input type="text" name="data2"/>
    &nbsp;&nbsp;
    <input type="submit" value="Get방식 전송"/>
</form>

</body>
</html>