<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-17
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
    window.onload = function () {
        document.getElementById( "btn" ).onclick = function() {
        if ( document.frm.ename.value.length < 1 ) {
            alert( "사원이름을 1자 이상 입력해주세요" );
            return;
        }
            alert( "정상" );
            document.frm.submit();
        };
    };
    </script>
</head>
<body>

<form action="emp_ok.jsp" method="post" name="frm">
    사원이름 : <input type="text" name="ename" />
    <input type="button" id="btn" value="사원 이름 검색기" />
</form>

</body>
</html>
