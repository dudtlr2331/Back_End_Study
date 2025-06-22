<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        window.onload = function (){
            document.getElementById('btn').onclick = function () {
                if (document.frm.dong.value.trim().length < 2) {
                    alert('동이름을 2자 이상 입력해주세요.')
                    return;
                }

                document.frm.submit();
            }
        };
    </script>
</head>
<body>

<form action="/zipcode_ok" method="post" name="frm">
    <fieldset>
        <legend>우편번호 검색기</legend>
        <label for="dong">동이름 검색</label>
        <input type="text" id="dong" name="dong" size="40" placeholder="동이름 입력">
        <input type="button" id="btn" value="우편번호 검색">
    </fieldset>
</form>

</body>
</html>
