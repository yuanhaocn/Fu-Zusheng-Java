<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线用户</title>
</head>
<body>
	<jsp:include page="/common/head.jsp"></jsp:include>
	<table border="1" cellpadding="5" cellspacing="0" align="center"
		width="80%">
		<tr>
			<td colspan="2" align="center"><h3>在线列表展示：</h3></td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
		</tr>
		<c:if test="${not empty applicationScope.onLineList}">
			<c:forEach items="${applicationScope.onLineList}" var="admin">
				<tr>
					<td>${admin.id}</td>
					<td>${admin.name}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>