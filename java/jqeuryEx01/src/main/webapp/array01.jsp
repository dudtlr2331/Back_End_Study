<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        // [] - 배열
        // {} - 객체

        const array = [
            { name: 'daum', link: 'https://www.daum.net'},
            { name: 'naver', link: 'https://www.naver.com'},
            { name: 'google', link: 'https://www.google.com'}
        ];

        console.log(array);

        // for (let i = 0; i < array.length; i++){
        //     console.log(array[i].name);
        //     console.log(array[i].link);
        // }

        // for (let i in array){
        //     console.log(array[i].name);
        //     console.log(array[i].link);
        // }
        //
        // for (let obj of array){
        //     console.log(obj.name);
        //     console.log(obj.link);
        // }

        // 함수 사용 처리
        // array.forEach(function (item){
        //     console.log(item.name);
        //     console.log(item.link);
        // });

        array.forEach(function (item, index){
            console.log(index + ' : ' + item.name);
            console.log(index + ' : ' + item.link);
        });

        //jQuery적으로 처리
        $.each(array, function (index, item){
            console.log(index + ' : ' + item.name);
            console.log(index + ' : ' + item.link);
        });

        // data + html 결합
        $.each(array, function (index, item){
            let html = "";
            html += "<a href='" + item.link + "'>";
            html += item.name;
            html += "</a><br/>";

            document.body.innerHTML += html;
        });


    });
</script>
</head>
<body>

</body>
</html>