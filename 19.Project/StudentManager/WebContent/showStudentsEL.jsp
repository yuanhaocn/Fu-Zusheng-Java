<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="com.qfedu.domain.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>number</th>
				<th>name</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<!-- 
			var是循环变量本身，也就是具体的当前的student对象
			items是要遍历的集合
			 -->
			<c:forEach var="student" items="${lists}">
				<tr>
					<td>${student.number}</td>
					<td>${student.name}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>