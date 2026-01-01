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
                            // console.log( request.responseText );

                            const  xmlData = request.responseXML;

                            const movieNms = xmlData.getElementsByTagName("movieNm");
                            console.log(movieNms.length);
                            console.log(movieNms[0]);
                            console.log(movieNms[0].innerHTML);

                        } else {
                            alert( '잘못된 페이지로 접근' );
                        }
                    }
                };

                request.open( 'get', 'http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=166c66a6369cc109ac12ca20495c5218&targetDt=20250510', true );
                request.send();

            };
        };

    </script>
</head>
<body>

<button id="btn">비동기식 요청하기</button>

</body>
</html>