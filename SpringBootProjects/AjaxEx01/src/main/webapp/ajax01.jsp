<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript">
        // javascript
        window.onload = function () {
            document.getElementById( 'btn1' ).onclick = function () {

                console.log( '1' );
                const request = new XMLHttpRequest();
                //request.open( 'get', './data/data.csv', false );
                request.open( 'get', 'http://localhost:8080/Gradle___org_example___AjaxEx01_1_0_SNAPSHOT_war/data/data.csv', false );
                console.log( '2' );
                request.send();
                console.log( '3' );
                console.log( request.responseText );
                console.log( '4' );

            };

            document.getElementById( 'btn2' ).onclick = function () {

                console.log( '1' );
                const request = new XMLHttpRequest();

                // 비동기 처리에 대한 이벤트
                request.onreadystatechange = function () {
                    console.log( 'readyState : ' + request.readyState );
                    // 1. request 객체를 만들고 초기화한 다음 send는 실행하지 않음
                    // 2. send 메서드를 사용했지만 아직 데이터를 받지 않음
                    // 3. 데이터의 일부를 받음
                    // 4. 모든 데이터를 받음(O)

                    if ( request.readyState == 4 ) {
                        //console.log( "status : " + request.status );
                        if ( request.status == 200 ) {
                            console.log( request.responseText );
                        } else {
                            alert( '잘못된 페이지로 접근' );
                        }
                    }
                };

                request.open( 'get', './data/data.csv', true );
                console.log( '2' );
                request.send();
                console.log( '3' );
                console.log( request.responseText );
                console.log( '4' );

            };
        };

    </script>
</head>
<body>

<button id="btn1">동기식 요청하기</button>
<button id="btn2">비동기식 요청하기</button>

</body>
</html>