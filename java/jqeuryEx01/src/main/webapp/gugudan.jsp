<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
        $(document).ready( function() {
            document.getElementById('btn').onclick = function() {
                // const startdan = document.wfrm.startdan.value;
                // const enddan = document.wfrm.enddan.value;
                //
                // console.log(startdan);
                // console.log(enddan);

                const iStartDan = parseInt(startdan);
                const iEndDan = parseInt(enddan);

                let html = '<table border="1" cellspacing="0">';
                for (let i = iStartDan; i <= iEndDan; i++) {
                    html += '<tr>';
                    for (let j = 1; j <= 9; j++) {
                        html += '<td>' + i + ' x ' + j + ' = ' + (i * j) + '</td>';
                    }
                    html += '</tr>';
                }
                html += '</table>';

                $('#result').html(html);
            };
        });
    </script>
</head>
<body>
<form name="wfrm">
    시작단 <input type="text" id="startdan" name="startdan" />
    ~
    끝단 <input type="text" id="enddan" name="enddan" />
    &nbsp;&nbsp;
    <input type="button" id="btn" value="구구단 출력" />
</form>

<br /><hr /><br />
</body>
</html>