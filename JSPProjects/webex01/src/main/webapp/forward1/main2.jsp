<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-21
  Time: 오전 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="view.jsp" method="post">
    보고싶은 페이지 선택 :
    <select name="code">
        <option value="a">a 페이지</option>
        <option value="b">b 페이지</option>
        <option value="c">c 페이지</option>
        <input type="submit" value="내용 보기"/>
    </select>

</form>
</body>
</html>
