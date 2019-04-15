<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>data4</title>
</head>
<body>
	<table align="center" width="50%" height="200px" border="1px" style="border-color: red" cellpadding="1px" cellspacing="0px">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>昵称</td>
		</tr>
		<c:forEach items="${persons}" var="person" varStatus="vs">
			<tr align="center">
				<td>${vs.count}</td>
				<td>${person.name}</td>
				<td>${person.nickname}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>