<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.pds.model.BoardTO" %>

<%
	ArrayList<com.example.pds.model.BoardTO> lists = (ArrayList<BoardTO>)request.getAttribute( "lists" );

	int totalRecord = lists.size();

	StringBuilder sbHtml = new StringBuilder();

	for( BoardTO to : lists ) {
		String seq = to.getSeq();
		String kind = to.getKind();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String fileName = to.getFileName();
		String wdate = to.getWdate();
		String hit = to.getHit();

		int wgap = to.getWgap();

		sbHtml.append( "<tr>" );
		if ( fileName.equals( "" ) ) {
			sbHtml.append( "<td></td>" );
		} else {
			sbHtml.append( "<td><img src='./images/icon_file.gif' /></td>" );
		}
		sbHtml.append( "<td>" + seq + "</td>" );

		sbHtml.append( "<td class='left'>" );
		sbHtml.append( "<a href='./view.do?seq=" + seq + "'>" + subject + "</a>&nbsp;" );
		if ( wgap == 0 ) {
			sbHtml.append("<img src='./images/icon_new.gif' alt='NEW'>");
		}
		sbHtml.append( "</td>" );

		sbHtml.append( "<td>" + writer + "</td>" );
		sbHtml.append( "<td>" + wdate + "</td>" );
		sbHtml.append( "<td>" + hit + "</td>" );
		sbHtml.append( "<td>" + kind + "</td>" );

		sbHtml.append( "</tr>" );
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<div class="board_top">
			<div class="bold">총 <span class="txt_orange"><%= totalRecord %></span>건</div>
		</div>

		<!--게시판-->
		<div class="board">
			<table>
			<tr>
				<th width="3%">&nbsp;</th>
				<th width="5%">번호</th>
				<th>제목</th>
				<th width="10%">글쓴이</th>
				<th width="10%">등록일</th>
				<th width="5%">조회</th>
				<th width="5%">분류</th>
			</tr>

				<%= sbHtml %>

			</table>
		</div>	

		<div class="btn_area">
			<div class="align_right">
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='write.do'" />
			</div>
		</div>
		<!--//게시판-->
	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
