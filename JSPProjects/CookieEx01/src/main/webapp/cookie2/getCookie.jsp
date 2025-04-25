<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- getCookie.jsp -->
<%
    Cookie[] cookies = request.getCookies();

    // 쿠키의 갯수
    //out.println( "쿠키갯수 : " + cookies.length + "<br />");
    //out.println( "쿠키데이터 : " + java.util.Arrays.toString( cookies ) + "<br />");

    //
    //out.println( cookies[0].getName() + "<br />");
    //out.println( cookies[0].getValue() + "<br />");

    // 전체 쿠키

    // age - 쿠키의 유효시간(브라우저 종료되어도 쿠키가 남아 있는 시간 : 초)

    if ( cookies != null && cookies.length > 0 ) {
        for ( int i=0 ; i<cookies.length ; i++ ) {
            out.println( cookies[i].getName() + " / " + cookies[i].getValue() + "/" + cookies[i].getMaxAge() + "<br />");
        }
    } else {
        out.println( "쿠키 없음" );
    }
%>
