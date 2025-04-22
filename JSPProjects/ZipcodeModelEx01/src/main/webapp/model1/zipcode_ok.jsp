<%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 2025-04-22
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="org.example.model1.ZipcodeTO" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<ZipcodeTO> lists = (ArrayList<ZipcodeTO>)request.getAttribute( "lists" );

	StringBuilder sbHtml = new StringBuilder();

	sbHtml.append( "<table width='800' border='1' cellspacing='0'>" );
	for ( ZipcodeTO to : lists ) {
		sbHtml.append( "<tr>" );
		sbHtml.append( "<td>" + to.getZipcode() + "</td>" );
		sbHtml.append( "<td>" + to.getSido() + "</td>" );
		sbHtml.append( "<td>" + to.getGugun() + "</td>" );
		sbHtml.append( "<td>" + to.getDong() + "</td>" );
		sbHtml.append( "<td>" + to.getRi() + "</td>" );
		sbHtml.append( "<td>" + to.getBunji() + "</td>" );
		sbHtml.append( "</tr>" );
	}
	sbHtml.append( "</table>" );
%>
<html>
<head>
	<title>Title</title>
</head>
<body>

zipcode_ok.jsp
<hr />
<%=sbHtml.toString() %>
</body>
</html>
