<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示用户信息</title>
</head>
<body>
	<table border="1px" width="50%" align="center" cellpadding="1px"
		cellspacing="0px">
		<tr align="center">
			<td>姓名</td>
			<td>年龄</td>
			<td>地址</td>
			<td>日期</td>
		</tr>
		<tr align="center">
			<td>${vo.user.username}</td>
			<td>${vo.user.age }</td>
			<td>${vo.user.address }</td>
			<!-- fmt:用来将特定的日期值转为指定的格式! -->
			<td><fmt:formatDate value="${vo.user.birthday }" pattern="yyyy-MM-dd"/></td>
		</tr>
	</table>
</body>
</html>