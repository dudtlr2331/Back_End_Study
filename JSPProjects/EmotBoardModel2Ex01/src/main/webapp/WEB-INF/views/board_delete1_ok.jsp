﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="org.example.model1.BoardTO" %>

<%
    int flag = (Integer) request.getAttribute("flag");

    out.println("<script type='text/javascript'>");
    if(flag == 0) {
        out.println("alert('글삭제 성공');");
        out.println("location.href = './controller?path=list';");
    } else if (flag == 1) {
        out.println("alert('비밀번호 오류');");
        out.println("history.back();");
    } else {
        out.println("alert('글삭제 실패');");
        out.println("history.back();");
    }
    out.println("</script>");
%>