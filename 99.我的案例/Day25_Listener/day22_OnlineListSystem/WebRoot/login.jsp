<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆系统</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login?method=login" method="post">
		<table border="1" width="75%" cellpadding="5" cellspacing="0"
			align="center">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>密&nbsp;码:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="登陆"></td>
			</tr>
		</table>
	</form>
</body>
</html>