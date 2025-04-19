<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- calendar_form01 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="calendar_form01_ok.jsp" method="post">
  <input type="text" name="year"> 년
  &nbsp;&nbsp;
  <input type="text" name="month"> 월
  &nbsp;&nbsp;
  <input type="submit" value="달력보기">
</form>

<hr/>

<form action="calendar_form01_ok.jsp" method="post">
  <select name="year">
    <option value="2024">2024</option>
    <option value="2025">2025</option>
    <option value="2026">2026</option>
    <option value="2027">2027</option>
  </select>년
  &nbsp;&nbsp;
  <select name="month">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
  </select>월
  <br>
  <input type="submit" value="달력보기">
</form>

</body>
</html>
