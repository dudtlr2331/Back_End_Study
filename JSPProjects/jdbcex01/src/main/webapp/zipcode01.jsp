<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-17
  Time: 오전 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script>
        const checkfrm = function (){
            let dong = document.frm.dong.value;
            // if(dong.length < 0){
            //     alert("동이름을 2자 이상 입력해 주세요.");
            // } else{
            //     alert("정상");
            // }

            if(dong.length < 0){
                alert("동이름을 2자 이상 입력해 주세요.");
                return;
            }
            alert("정상");

            document.frm.submit();

        };
    </script>
</head>
<body>

<form action="zipcode_ok.jsp" method="post">
    동이름 : <input type="text" name="dong">
    <input type="submit" value="우편번호 검색기">
</form>

<hr/>

<form action="zipcode_ok.jsp" method="post" name="frm">
    동이름 : <input type="text" name="dong">
    <input type="button" value="우편번호 검색기" onclick="checkfrm()">
</form>

</body>
</html>
