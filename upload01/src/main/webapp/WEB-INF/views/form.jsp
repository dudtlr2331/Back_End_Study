<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<>

form.jsp
<br /><hr />

<form action="form_ok.do" method="post" enctype="multipart/form-data">
    파일 <input type="file" name="upload" />
    <input type="submit" name="파일 전송" />
</form>

<br /><hr /><br />

<form action="form_ok.do" method="post" enctype="multipart/form-data">
    데이터 <input type="text" name="data" />
    파일 <input type="file" name="upload" />
    <input type="submit" name="파일 전송" />
</form>

<form action="form_ok2.do" method="post" enctype="multipart/form-data">
    파일1 <input type="file" name="upload1" />
    파일2 <input type="file" name="upload2" />
    <input type="submit" name="파일 전송" />
</form>


</body>
</html>