<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        document.getElementById('btn1').onclick = function (){
            // const html = documnet.getElementById('result');
            // console.log(html);
            // console.log(html.innerHTML);
            // console.log(html.textContent);

            console.log($('#result'));
            console.log($('#result').html());
            console.log($('#result').text());
        }
    });
</script>
</head>
<body>

<button id="btn1">내용확인</button>
<br/><hr/><hr/>
<div id="result"><b>출력 내용</b></div>

</body>
</html>