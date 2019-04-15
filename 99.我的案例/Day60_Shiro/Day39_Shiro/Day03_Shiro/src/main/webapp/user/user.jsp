<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入Shrio的标签库 -->
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User页面</title>
</head>
<body>
	<h1>普通的User可以看的页面</h1>

	<h3>
		<!-- shiro:principal:是通过正常登陆来获得用户名. -->
		<p>1.欢迎[<shiro:principal/>]光临</p>
		<!-- shiro:user,是通过rememberMe功能来获得的用户姓名 -->
		<p>2.欢迎[<shiro:user/>]光临</p>
		<br>
		<shiro:authenticated>已经经过了认证!</shiro:authenticated>
	</h3>
	<br>
	<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>