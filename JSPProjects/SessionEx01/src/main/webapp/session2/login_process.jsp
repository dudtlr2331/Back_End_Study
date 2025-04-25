
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- login_process --%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    // 회원가입정보
    String saveId = "tester";
    String savePassword = "123456";

    int flag = 2;

    // 로그인 검사
    if(id.equals(saveId) && password.equals(savePassword)){
        // 정상 로그인
        flag = 0;

        // 로그인 상태 확인을 위한 세션부여
        session.setAttribute("sessId", id);
        session.setAttribute("sessGrade", "B");

    } else {
        // 아이디나 비밀번호 틀림
        flag = 1;
    }

    out.println("<script type='text'/javascript'>");
    if(flag == 0){
        out.println("alert('로그인 되었습니다.')");
        out.println("location.href='login_complete.jsp';");
    } else if(flag == 1){
        out.println("alert('아이디나 비밀번호 오류')");
        out.println("history.back();");
    } else  if(flag == 2){
        out.println("alert('기타 오류')");
        out.println("history.back();");
    }
    out.println("</script>");
%>