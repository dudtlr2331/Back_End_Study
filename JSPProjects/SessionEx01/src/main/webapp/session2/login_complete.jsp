<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- login_complete --%>
<%--
    로그인 안된 사람 + 세션 없는 사람은 접근 불가
--%>
<%
    if(session.getAttribute("sessId") != null){
%>
<html>
<head>
    <title>Document</title>
</head>
<body>

</body>
</html>
<%
    } else {
%>
    <script type="text/javascript">
        alert('로그인 하셔야 합니다.');
        history.back();
    </script>
<%
    }
%>