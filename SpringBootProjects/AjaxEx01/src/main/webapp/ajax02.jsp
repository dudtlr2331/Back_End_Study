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

                            const csvData = request.responseText.trim();
                            const rowdatas = csvData.split('\n');

                            let html = '<table>';
                            for(let i=0; i<rowdatas.length; i++){
                                let coldatas = rowdatas[i].split(',');
                                html += '<tr>';
                                html += '<td>' + coldatas[0] + '</td>';
                                html += '<td>' + coldatas[1] + '</td>';
                                html += '<td>' + coldatas[2] + '</td>';
                                html += '<td>' + coldatas[3] + '</td>';
                                html += '</tr>';
                            }
                            html += '</table>';

                            document.getElementById('result').innerHTML = html;

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

<br/><hr/><br/>

<div id="result"></div>

</body>
</html>