<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 导入标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息展示界面</title>
</head>
<body>
	
	<!-- 引入通用的头部视图 -->
	<jsp:include page="/common/head.jsp"></jsp:include>	

	欢迎你,${sessionScope.loginUser.name }; 

	<table align="center" width="80%" border="1" cellpadding="5"
		cellspacing="0">
		<tr align="center">
			<td>编号</td>
			<td>用户ID</td>
			<td>用户姓名</td>
		</tr>
		<!-- jstl:标签 -->
		<c:choose>
			<c:when test="${not empty requestScope.users}">
				<c:forEach items="${requestScope.users}" var="user" varStatus="vs">
					<tr align="center">
						<td>${vs.count}</td>
						<td>${user.id}</td>
						<td>${user.username}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td colspan="3">数据为空!</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>