<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示信息</title>
</head>
<body>
	<h1>展示信息</h1>
	<c:if test="${not empty sessionScope.user}">
		${sessionScope.user.username},你好!
	</c:if>
	
	<a href="logout.action">退出</a>

</body>
</html>