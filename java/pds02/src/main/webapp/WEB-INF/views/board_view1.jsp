<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.example.pds.model.BoardTO" %>

<%
	BoardTO to = (BoardTO)request.getAttribute( "to" );

	String seq = to.getSeq();
	String subject = to.getSubject();
	String kind = to.getKind();
	String writer = to.getWriter();
	String mail = to.getMail();
	String wip = to.getWip();
	String wdate = to.getWdate();
	String hit = to.getHit();
	String content = to.getContent();
	String fileName = to.getFileName();
	String file = "";
	if ( !fileName.equals( "" ) ) {
		file = fileName + "(" + to.getFileSize() + " byte)";
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
<script type="text/css">
	.next_data_area { margin-top: 20px; padding-top: 5px; padding-left: 8px; text-align: left;border-top: 1px solid #dadada; }
	.prev_data_area { margin-top: 10px; margin-bottom: 10px; padding-top: 5px;padding-bottom: 5px; padding-left: 8px; text-align: left; border-bottom: 1px solid #dadada; }
	.next_data_area .b{ font-weight: bold; }
	.prev_data_area .b{ font-weight: bold; }
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">분류</th>
				<td width="60%"><%= kind %></td>
				<th width="10%">등록일</th>
				<td width="20%"><%= wdate %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%= subject %></td>
				<th>글쓴이</th>
				<td><%= writer %></td>
			</tr>
			<tr>
				<th>정보</th>
				<td><%= mail %>(<%= wip %>)</td>
				<th>조회</th>
				<td><%= hit %></td>
			</tr>
			<tr>
				<th>첨부 파일</th>
				<td><%= file %></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding: 20px; line-height: 160%"><%= content %></td>
			</tr>
			</table>
		</div>

		<!-- 이전글 / 다음글 -->
		<br />
		<div class="btn_area">
			<div class="next_data_area">
				<span class="b">다음글 | </span><a href="board_view1.jsp">다음글이 없습니다.</a>
			</div>
			<br />
			<div class="prev_data_area">
				<span class="b">이전글 | </span><a href="board_view1.jsp">이전글이 없습니다.</a>
			</div>
		</div>
		<br />
		<!-- //이전글 / 다음글 -->

		<div class="btn_area">
			<div class="align_left">
				<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='list.do'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./modify.do?seq=<%=seq %>'" />
				<input type="button" value="삭제" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./delete.do?seq=<%=seq %>'" />
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='./write.do'" />
			</div>
		</div>

		<!--//게시판-->
	</div>
</div>
<!-- 하단 디자인 -->

</body>
</html>
