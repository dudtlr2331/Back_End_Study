<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="https://search.naver.com/search.naver" method="get">
  검색어 <input type="text" name="query">
  <input type="submit" value="네이버에서 검색">
</form>

<%-- http://localhost:8080/form_ok.jsp?data1=값1&data2=값2 --%>

<hr/>

<form action="form_ok.jsp" method="get">
  데이터1 <input type="text" name="data1"><br/><br/>
  데이터2 <input type="text" name="data2"><br/><br/>
  <input type="submit" value="get 방식 전송">
</form>

<hr/>

<a href="./form_ok.jsp?data1=value1&data2=value2">get 방식 전송</a>

<hr/>

<form action="form_ok.jsp" method="post">
  데이터1 <input type="text" name="data1"><br/><br/>
  데이터2 <input type="text" name="data2"><br/><br/>
  <input type="submit" value="post 방식 전송">
</form>

</body>
</html>
