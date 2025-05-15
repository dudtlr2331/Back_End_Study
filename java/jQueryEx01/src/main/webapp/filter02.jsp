<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $('h3').css('background-color', 'orange').filter(':even').css('color', 'red').end().filter();

    });
</script>
</head>
<body>

<h3>Hello jQuery1</h3>
<h3>Hello jQuery2</h3>
<h3>Hello jQuery3</h3>
<h3>Hello jQuery4</h3>
<h3>Hello jQuery5</h3>
<h3>Hello jQuery6</h3>

</body>
</html>