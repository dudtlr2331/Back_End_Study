﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ page import="com.example.pds.model.BoardTO" %>

<%
	com.example.pds.model.BoardTO to = (BoardTO)request.getAttribute( "to" );

	String seq = to.getSeq();
	String subject = to.getSubject();
	String writer = to.getWriter();
	String[] mail = null;
	if ( to.getMail().equals( "" ) ) {
		mail = new String[] { "", "" };
	} else {
		mail = to.getMail().split( "@" );
	}
	String content = to.getContent();
	String fileName = to.getFileName();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="./css/board.css">
	<script type="text/javascript">
        window.onload = function() {
            document.getElementById( 'mbtn' ).onclick = function() {
                if( document.mfrm.subject.value == '' ) {
                    alert( '제목을 입력하셔야 합니다.' );
                    return false;
                }
                if( document.mfrm.password.value == '' ) {
                    alert( '비밀번호를 입력하셔야 합니다.' );
                    return false;
                }

                document.mfrm.submit();
            };
        }
	</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<form action="./modify_ok.do" method="post" name="mfrm" enctype="multipart/form-data">
		<input type="hidden" name="seq" value="<%=seq %>" />
		<div class="contents_sub">
			<!--게시판-->
			<div class="board_write">
				<table>
					<tr>
						<th class="top">글쓴이</th>
						<td class="top"><input type="text" name="writer" value="<%=writer %>" class="board_view_input_mail" maxlength="5" readonly/></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" value="<%=subject %>" class="board_view_input" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password" value="" class="board_view_input_mail"/></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content" class="board_editor_area"><%=content %></textarea></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="mail1" value="<%=mail[0] %>" class="board_view_input_mail"/> @ <input type="text" name="mail2" value="<%=mail[1] %>" class="board_view_input_mail"/></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							기존 파일명 : <%=fileName %><br /><br />
							<input type="file" name="upload" value="" />
						</td>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./list.do'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./view.do?seq=<%=seq %>'" />
				</div>
				<div class="align_right">
					<input type="button" id="mbtn" value="수정" class="btn_write btn_txt01" style="cursor: pointer;" />
				</div>
			</div>
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
