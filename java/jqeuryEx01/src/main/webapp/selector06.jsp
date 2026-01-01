<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // 속성 selector

        // $('input[type="text"]').css('background-color', 'red');

        // 시작 문자열
        // $('input[type^="te"]').css('background-color', 'red');
        // 끝 문자열
        $('input[data$="t1"]').css('background-color', 'red');


    });
</script>
</head>
<body>

<input type="text" data="text1"/><br/><br/>
<input type="text" data="text2"/><br/><br/>
<input type="password" data="text3"/><br/><br/>

</body>
</html>