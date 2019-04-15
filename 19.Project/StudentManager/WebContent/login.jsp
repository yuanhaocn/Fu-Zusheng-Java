<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginServlet" method="post">
		number:<input type="text" name="number" /><br>
		password:<input type="password" name="password"/><br> 
		<input type="checkbox" value="yes" name="remeber" />自动登录<br> 
		<input type="submit" value="登录" />
	</form>
</body>
</html>