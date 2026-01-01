<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        // dom 선택 - selector
        // 글자 색을 레드로
        // $('*').css('color', 'red');

        $('*').css({
           color: 'blue'
        });
    });
</script>
</head>
<body>

<h2>Hello jQuery 1</h2>
<h2>Hello jQuery 2</h2>
<h2>Hello jQuery 3</h2>
<h2>Hello jQuery 4</h2>
<h2>Hello jQuery 5</h2>

</body>
</html>