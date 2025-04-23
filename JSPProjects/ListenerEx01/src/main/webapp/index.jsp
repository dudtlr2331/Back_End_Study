<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>

Hello JSP
<%
    ServletContext context = config.getServletContext();
    context.setAttribute("name", "홍길동");

    out.println("context : " + context.getAttribute("name") + "<br/>");
    out.println("application : " + application.getAttribute("name") + "<br/>");

    context.removeAttribute("name");

    out.println("application : " + application.getAttribute("name") + "<br/>");
%>

</body>
</html>