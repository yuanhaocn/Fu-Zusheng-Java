<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页面</title>
</head>
<body>
	<!-- 未登录 -->
	<c:if test="${empty user}">
		<a href="login.jsp">登陆</a>
		<a href="register.jsp">注册</a>
	</c:if>
	
	<!-- 登陆 -->
	<c:if test="${not empty user }">
		欢迎 ${user.username} 登陆,<a href="${pageContext.request.contextPath}/logout">注销</a>
	</c:if>
</body>
</html>