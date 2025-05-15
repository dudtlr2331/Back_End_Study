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
                            //문자열
                            console.log(request.responseText);
                            //XML
                            console.log(typeof request.responseXML);

                            const xmlData = request.responseXML;

                            const names = xmlData.getElementsByTagName('name');
                            const publisher = xmlData.getElementsByTagName('publisher');
                            const author = xmlData.getElementsByTagName('author');
                            const price = xmlData.getElementsByTagName('price');
                            // console.log(names.length);
                            // console.log(names[0]);
                            // console.log(names[0].innerHTML);
                            // console.log(names[0].textContent);

                            for (let i = 0; i < names.length; i++){
                                console.log(names[i].innerHTML);
                                console.log(publisher[i].innerHTML);
                                console.log(author[i].innerHTML);
                                console.log(price[i].innerHTML);
                            }
                        } else {
                            alert( '잘못된 페이지로 접근' );
                        }
                    }
                };

                request.open( 'get', './data/data.xml', true );
                request.send();

            };
        };

    </script>
</head>
<body>

<button id="btn">비동기식 요청하기</button>

</body>
</html>