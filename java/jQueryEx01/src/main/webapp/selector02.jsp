<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        // $('h2').css('color', 'red');
        // $('h3').css('color', 'yellow');
        // $('h'+'2').css('color', 'yellow');
        const selector = 'h3';
        const attribute = 'color';
        const value = 'magenta';
        // $(selector).css(attribute, value);

        $('h2, h3').css('color', 'yellow');

    });
</script>
</head>
<body>

<h2>Hello jQuery 1</h2>
<h3>Hello jQuery 2</h3>
<h2>Hello jQuery 3</h2>
<h3>Hello jQuery 4</h3>
<h2>Hello jQuery 5</h2>

</body>
</html>