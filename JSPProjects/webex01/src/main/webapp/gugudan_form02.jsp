<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String startdan = request.getParameter("startdan");
    String enddan = request.getParameter("enddan");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="gugudan_form02.jsp" method="post">
    시작단 <input type="text" name="startdan">
    ~
    끝단 <input type="text" name="enddan">
    <input type="submit" value="구구단 출력">
</form>


<hr/>

<%
    if(startdan != null && enddan != null){
        int iStartDan = Integer.parseInt(startdan);
        int iEndDan = Integer.parseInt(enddan);

        out.println( "<table border='1' cellspacing='0'>" );
        for ( int dan=iStartDan ; dan<=iEndDan ; dan++ ) {
            out.println( "<tr>" );
            for ( int col=0 ; col<=9 ; col ++ ) {
                if ( dan==0 && col==0 ) {
                    out.println( "<td></td>" );
                } else if ( dan == 0 ) {
                    out.println( "<td>X" + col + "</td>" );
                } else if ( col == 0 ) {
                    out.println( "<td>" + dan + "단</td>" );
                } else {
                    out.println( "<td>" + dan + "X" + col + "=" + (dan*col) + "</td>" );
                }
            }
            out.println( "</tr>" );
        }
        out.println( "</table>" );
    }
%>

</body>
</html>