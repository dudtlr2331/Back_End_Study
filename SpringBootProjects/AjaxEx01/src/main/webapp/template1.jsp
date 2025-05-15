<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        // javascript
        window.onload = function () {
            document.getElementById( 'btn' ).onclick = function () {

                const request = new XMLHttpRequest();
                request.onreadystatechange = function () {
                    if ( request.readyState == 4 ) {
                        if ( request.status == 200 ) {
                            console.log( request.responseText );
                        } else {
                            alert( '잘못된 페이지로 접근' );
                        }
                    }
                };

                request.open( 'get', './data/data.csv', true );
                request.send();

            };
        };

    </script>
</head>
<body>

<button id="btn">비동기식 요청하기</button>

</body>
</html>