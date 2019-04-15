<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home主页</title>
</head>
<body>
	<h1>当前登陆的用户未:[${currentUser}]</h1>
	
	<a href="${pageContext.request.contextPath}/visitor/visitor.jsp">Visitor用户可以访问的页面</a><br>
	
	<a href="${pageContext.request.contextPath}/user/user.jsp">User用户可以访问的页面</a><br>
	
	<a href="${pageContext.request.contextPath}/admin/admin.jsp">Admin用户可以访问的页面</a><br>
	
	<a href="${pageContext.request.contextPath}/user/logout">退出</a><br>
</body>
</html>