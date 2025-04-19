<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오전 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
  // 메서드 선언
  public int multiply(int a, int b){
    int result = a + b;
    return result;
  }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  int a = 10;
  int b = 20;
  int result = multiply(a, b);

  out.println("결과 : " + result);
%>

<hr/>

10 * 25 = <%= multiply(10, 25)%> <br/>

a * b = <%= multiply(a, b)%>

</body>
</html>
