<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- fmt:是关于国际化的标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--注意:尽量不要在jsp页面中去写java代码.  -->
<!-- 在el表达式中,request对象内部就已经封装了一个locale对象. -->
<!-- locale=Locale.getDefault(); -->
<!-- 设置本地化对象 -->
<fmt:setLocale value="${pageContext.request.locale }" />
<!-- 设置资源包 -->
<fmt:setBundle basename="com.syc.i18n.login" var="bundle"/>
<!-- fmt:message标签用来去某个包下面引用某个key对应的值 -->
<title><fmt:message key="title" bundle="${bundle}"></fmt:message></title>
</head>
<body>
	<form action="#" method="post">
		<fmt:message key="name" bundle="${bundle}"></fmt:message>:<input type="text" name="name"><br />
		<fmt:message key="pass" bundle="${bundle}"></fmt:message>:<input type="password" name="pass"><br /> 
		<!-- message标签中,var是用来定义变量的. -->
		<fmt:message key="submit" bundle="${bundle}" var="msg"></fmt:message> 
		<!-- 引用某个字符串 -->
		<input type="submit" value="${msg}">
	</form>
</body>
</html>