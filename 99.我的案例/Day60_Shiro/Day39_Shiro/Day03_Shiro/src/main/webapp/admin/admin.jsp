<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入Shrio的标签库 -->
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin页面</title>
</head>
<body>
	<h1>Admin身份才能看的页面....</h1>
	<h3>欢迎[<shiro:principal/>]光临</h3>
	<br>
	<!-- authenticated标签包含用户经过认证 登陆后获得信息 -->
	<shiro:authenticated>已经经过了认证!</shiro:authenticated>
	<br>
	<!-- user标签包含用户经过认证/记住我 登陆后获得信息 -->
	<shiro:user>已经经过了认证!.....</shiro:user>
	<br>
	
	<shiro:hasRole name="管理员">
		<h1>管理员可以看到的内容!</h1>
	</shiro:hasRole>
	
	<shiro:hasAnyRoles name="员工">
		<h1>普通员工可以看到的内容!</h1>
	</shiro:hasAnyRoles>
	
	<shiro:hasPermission name="admin:manager">
		<h1>管理员权限的人可以看到的内容!</h1>
	</shiro:hasPermission>
		
	<br>
	<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>