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
	<table>
		<c:if test="${page!=null }">
			<thead>
				<tr>
					<th>number</th>
					<th>name</th>
					<th>age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${page.studentList}">
					<tr>
						<td>${student.sid}</td>
						<td>${student.sname }</td>
						<td>${student.age }</td>
					</tr>
				</c:forEach>
			</tbody>
			<c:if test="${page.thisPage!=1}">
				<a href="${pageContext.request.contextPath}/selectStudentServlet?thisPage=1"> 首页</a>
				<a href="${pageContext.request.contextPath}/selectStudentServlet?thisPage=${page.thisPage-1}"> 上一页</a>

			</c:if>
			<c:if test="${page.thisPage!=page.endPage}">
				<a href="${pageContext.request.contextPath}/selectStudentServlet?thisPage=${page.thisPage+1}">下一页</a>
				<a href="${pageContext.request.contextPath}/selectStudentServlet?thisPage=${page.endPage}"> 尾页</a>
			</c:if>
		</c:if>

	</table>
</body>
</html>