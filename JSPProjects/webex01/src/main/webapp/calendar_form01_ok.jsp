<%--
  Created by IntelliJ IDEA.
  User: 영식
  Date: 2025-04-16
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<%
  String strYear = request.getParameter("year");
  String strMonth = request.getParameter("month");
%>


<style>
  table {
    align-content: center;
    width: 900px;
    border-collapse: collapse;
  }

  table, td{
    border: 1px solid black;
  }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  int year = Integer.parseInt(strYear);
  int month = Integer.parseInt(strMonth);

  Calendar startCalendar = Calendar.getInstance();
  Calendar endCalendar = Calendar.getInstance();

  startCalendar.set( year, month-1, 1 );
  endCalendar.set( year, month, 1 - 1 );

  int startDayOfWeek = startCalendar.get( Calendar.DAY_OF_WEEK );
  int endDate = endCalendar.get( Calendar.DATE );

  int endDayOfWeek = endCalendar.get( Calendar.DAY_OF_WEEK );

  //System.out.println( " SU MO TU WE TH FR SA" );
  out.println( "<table>" );
  out.println( "<tr>" );
  out.println( "<td>SU</td><td>MO</td><td>TU</td><td>WE</td><td>TH</td><td>FR</td><td>SA</td>" );
  out.println( "</tr>" );

  out.println( "<tr>" );

  for ( int i=1 ; i<startDayOfWeek ; i++ ) {
    out.print( "<td></td>" );
  }

  for ( int i=1, n=startDayOfWeek ; i<=endDate ; i++, n++ ) {
    if( n % 7 == 1 ) {
      out.println( "<tr>" );
    }

    if(n % 7 == 1){
      out.println( "<td><font color='red'>" + i + "</font></td>" );
    } else if (n % 7 == 0) {
      out.println( "<td><font color='blue'>" + i + "</font></td>" );
    } else {
      out.println( "<td>" + i + "</td>" );
    }

    if( n % 7 == 0 ) {
      out.println( "</tr>" );
    }
  }

  for ( int i=endDayOfWeek ; i<=6 ; i++ ) {
    out.println( "<td></td>" );
  }

  out.println( "</tr>" );
  out.println( "</table>" );
%>
</body>
</html>
