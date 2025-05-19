<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script>
        $(document).ready( function (){
            $('#btn').on('click', function () {
                // alert('click');
                $.ajax('./data/data.csv',{
                    success: function (){
                        console.log('요청성공');
                    }

                    // ulr : 요청 data url
                    // data : 요청 파라미터
                    // type : get / post
                    // anync : 동기 / 비동기
                    // datatype : 요청 데이터의 형식
                    // success : 요청에 성공하면
                    // error :  요청에 실패하면

                })
            });
        });
    </script>
</head>
<body>

<button id="btn">비동기식 요청하기</button>

</body>
</html>
