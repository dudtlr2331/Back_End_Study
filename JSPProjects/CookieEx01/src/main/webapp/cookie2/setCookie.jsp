<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- setCookie.jsp -->

<%
    // 쿠키 생성
    Cookie cookie1 = new Cookie( "data1", "value1" );

    // age - 쿠키의 유효시간(브라우저 종료되어도 쿠키가 남아 있는 시간 : 초)
    // 사용예 : 24시간 동안 공지 안보기
    cookie1.setMaxAge( 30 * 60 );

    // 브라우저에 쿠키 전송
    response.addCookie( cookie1 );

    // 한 개 쿠키
    out.println( "쿠키명 : " + cookie1.getName() + "<br />" );
    out.println( "쿠키값 : " + cookie1.getValue() + "<br />"  );
%>