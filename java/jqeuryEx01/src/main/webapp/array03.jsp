<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // [] - 배열
        // {} - 객체

        const array = [
            {name: 'daum', link: 'https://www.daum.net'},
            {name: 'naver', link: 'https://www.naver.com'},
            {name: 'google', link: 'https://www.google.com'}
        ];

        let array2 = $.map(array1 , function (item, index){
            return item;
        });

        console.log(array2);

        let htmlArr = $('h3').map(function (index, item) {
            return item.innerHTML;
        });

        console.log(array2);

    });
</script>
</head>
<body>

</body>
</html>