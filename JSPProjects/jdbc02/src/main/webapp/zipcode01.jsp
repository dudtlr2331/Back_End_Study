<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        // html 문서를 다 읽으면(DOM) - 이벤트
        window.onload = function () {
            document.getElementById( "btn" ).onclick = function() {
                if ( document.frm.dong.value.length < 2 ) {
                    alert( "동이름을 2자 이상 입력해주세요" );
                    return;
                }
                alert( "정상" );
                document.frm.submit();
            };
        };
    </script>
</head>
<body>

<!-- 값에 대한 검사 어려움 -->
<form action="zipcode_ok.jsp" method="post">
    동이름 : <input type="text" name="dong" />
    <input type="submit" value="우편번호검색기" />
</form>

<hr />

<form action="zipcode_ok.jsp" method="post" name="frm">
    동이름 : <input type="text" name="dong" />
    <input type="button" id="btn" value="우편번호검색기" />
</form>

</body>
</html>