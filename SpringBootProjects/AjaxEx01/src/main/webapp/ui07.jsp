<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./css/base/jquery-ui.min.css" />
    <style type="text/css">
        body { font-size: 80%; }
    </style>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script type="text/javascript" src="./js/jquery-ui.min.js"></script>
    <script type="text/javascript">
        $(document).ready( function () {
            $( '#start' ).spinner({
                min: 1,
                max: 8
            });

            $( '#end' ).spinner({
                min: 2,
                max: 9
            });
        });
    </script>
</head>
<body>

<fieldset>
    <legend>구구단 출력</legend>
    <label for="start">시작단</label>
    <input type="text" id="start" value="1" readonly />
    ~
    <label for="end">끝단</label>
    <input type="text" id="end" value="2" readonly />
    &nbsp;&nbsp;
    <button id="btn">구구단 출력</button>
</fieldset>

<br ><hr /><br >
<div id="result">결과 : <br /></div>

</body>
</html>