<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // 자손 / 후손
            // $('div > *').css('color', 'red');
            // $('div  *').css('color', 'red');

            // $('div > p').css('color', 'red');
            // $('div p').css('color', 'blue');

            // 아우
            $('div + p').css('color', 'red');

        });
    </script>
</head>
<body>
<div>
    <ul>
        <li>사과</li>
        <li>수박</li>
        <li>딸기</li>
    </ul>
    <ul>
        <li>사과</li>
        <li>수박</li>
        <li>딸기</li>
    </ul>
</div>

<p>Hello jQuery1</p>
<div>
    <p>Hello jQuery2</p>
    <span>
        <p>Hello jQuery3</p>
    </span>
    <p>Hello jQuery4</p>
</div>
<p>Hello jQuery5</p>
<p>Hello jQuery6</p>

</body>
</html>