<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>首页</title>
</head>
<body>
	<h1>home页面....登陆成功!</h1>
	<hr>
	<a href="${pageContext.request.contextPath}/user/user.jsp">User用户可以访问的页面</a><br>
	<br>
	<a href="${pageContext.request.contextPath}/admin/admin.jsp">Admin用户可以访问的页面</a><br>
	
	<br>
	<a href="${pageContext.request.contextPath}/logout">退出</a>

</body>
</html>