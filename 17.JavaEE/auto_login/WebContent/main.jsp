<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 判断user对象不为空 -->
	<c:if test="${user!=null}">
	欢迎${user.number}，您已经登录成功
	</c:if>
	<!-- 判断user对象为空 -->
	<c:if test="${user==null }">
	您好，请<a href="login.jsp">登录</a>
	</c:if>

</body>
</html>