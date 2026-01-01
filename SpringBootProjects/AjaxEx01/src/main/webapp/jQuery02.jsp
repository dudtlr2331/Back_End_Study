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
                    url : './data/data.csv',
                    type : 'get',
                    dataType : 'text',
                    success: function (csvData){
                        console.log('요청성공 : ' + csvData);
                    },
                    error : function (err) {
                        // console.log('요청실패 ' + err.status);
                        console.log('요청실패 ' + err.responseText);
                    }
                })
            });
        });
    </script>
</head>
<body>

<button id="btn">비동기식 요청하기</button>

</body>
</html>
