<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
	登陆成功,${sessionScope.user.username},欢迎你!
	
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/user/logout.action">退出登陆</a>
</body>
</html>