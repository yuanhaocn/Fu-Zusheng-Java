<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>静态包含与动态包含</title>
</head>
<body>
	
	<!-- 静态包含:不携带请求参数 -->
	<%-- <jsp:include page="/head.jsp"></jsp:include> --%>
	
	<!-- 动态包含:携带请求参数 -->
	<jsp:include page="/head.jsp">
		<jsp:param value="syc" name="name"/>
	</jsp:include>
	
	<hr>
	
	<h1>jsp08页面</h1>
</body>
</html>