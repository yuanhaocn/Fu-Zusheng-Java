<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
</head>
<body>

	<table border="1" cellpadding="5px" cellspacing="0" width="60%" align="center">
		<tr align="center">
			<td>文件编号</td>
			<td>文件名称</td>
			<td>文件操作</td>
		</tr>
		<%-- <c:if test="${not empty requestScope.fileNames }"></c:if> --%>
		<c:choose>
			<c:when test="${not empty requestScope.fileNames }">
				<c:forEach items="${requestScope.fileNames}" var="entry" varStatus="vs">
					<tr align="center">
						<td>${vs.count}</td>
						<td>${entry.value}</td>
						<!-- http://localhost:8080/day23_updownload/file?method=download&fileName=437ae253-4848-42c2-8238-08cfa3710f13#filter模板 -->
						<%-- <td><a href="${pageContext.request.contextPath}/file?method=download&fileName=${entry.key}">下载</a></td> --%>
						<!-- url标签中value的值,就是servlet的url-pattern -->
						<c:url value="file" var="url">
							<c:param name="method">download</c:param>
							<c:param name="fileName">${entry.key}</c:param>
						</c:url>
						<!-- 引用url变量名 -->
						<td><a href="${url}">下载</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td colspan="3">没有可下载的文件!</td>
			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>