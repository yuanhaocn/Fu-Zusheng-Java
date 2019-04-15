<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示学生信息</title>
<style type="text/css">
table {
	border-collapse: collapse;
	margin: 0px auto;
	width: 60%;
}

table tr td{
	padding:10px;
	border:1px solid gray;
	text-align: center;
}

.head{
	background-color: gray;
	color: white;
}

.head td{
	border: 1px solid green;
}
</style>
</head>
<body>

	<%-- ${requestScope.students[0].name} --%>

	<%-- <c:forEach items="${students}" var="student" varStatus="vs">
		${vs.count}-姓名:${student.name}<br>
	</c:forEach> --%>

	<!-- table展示所有的学生信息 -->
	<table>
		<tr class="head">
			<td>序号</td>
			<td>学生学号</td>
			<td>学生姓名</td>
			<td>学生年龄</td>
			<td>学生性别</td>
			<td>Java</td>
			<td>JSP</td>
		</tr>
		<!-- jstl标签中嵌套html -->
		<c:forEach items="${students}" var="student" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
				<td>${student.gender}</td>
				<td>${student.java}</td>
				<td>${student.jsp}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>