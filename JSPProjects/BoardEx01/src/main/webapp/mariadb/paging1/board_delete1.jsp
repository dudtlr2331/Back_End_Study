﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");

	String subject = "";
	String writer = "";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mysql1" );

		conn = dataSource.getConnection();

		String sql = "select subject, writer from board1 where seq=?";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString( 1, seq );

		rs = pstmt.executeQuery();

		if ( rs.next() ) {
			subject = rs.getString( "subject" );
			writer = rs.getString( "writer" );
		}

	} catch ( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch ( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board.css">
<script>
	window.onload = function (){
		document.getElementById('dbtn').onclick = function () {
			if (document.dfrm.password.value == ''){
				alert('비밀번호를 입력하셔야 합니다.');
				return;
			}

			document.dfrm.submit();
		};
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<form action="board_delete1_ok.jsp" method="post" name="dfrm">
		<input type="hidden" name="seq" value="<%= seq %>" />
		<div class="contents_sub">	
			<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top"><input type="text" name="writer" value="<%= writer %>" class="board_view_input_mail" maxlength="5" readonly/></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" value="<%= subject %>" class="board_view_input" readonly/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" value="" class="board_view_input_mail"/></td>
				</tr>
				</table>
			</div>
			
			<div class="btn_area">
				<div class="align_left">
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.jsp?cpage=<%=cpage%>'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_view1.jsp?cpage=<%=cpage%>&seq=<%=seq%>'" />
				</div>
				<div class="align_right">
					<input type="button" id="dbtn" value="삭제" class="btn_write btn_txt01" style="cursor: pointer;" />
				</div>
			</div>
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
