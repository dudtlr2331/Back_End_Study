<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    form.jsp
<br/><hr/>

    <form action="./form_ok.do" method="get">
        데이터 : <input type="text" name="data"/>
        <input type="submit" value="get방식 전송"/>
    </form>

<br/>

    <form action="./form_ok.do" method="post">
        데이터 : <input type="text" name="data"/>
        <input type="submit" value="post방식 전송"/>
    </form>

    <form action="./form_ok.do" method="post">
        <input type="hidden" name="_method" value="put"/>
        데이터 : <input type="text" name="data"/>
        <input type="submit" value="post방식 전송"/>
    </form>

    <form action="./form_ok.do" method="post">
        <input type="hidden" name="_method" value="delete"/>
        데이터 : <input type="text" name="data"/>
        <input type="submit" value="post방식 전송"/>
    </form>


</body>
</html>