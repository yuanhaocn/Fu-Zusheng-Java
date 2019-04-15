<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	session是否可用?
	<%=session.getId()%>
	
	<hr>
	<!-- session存值 -->
	<% session.setAttribute("name", "syc"); %>
	session中的内容:<%=session.getAttribute("name") %>
</body>
</html>