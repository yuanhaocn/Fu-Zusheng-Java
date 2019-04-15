<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<table border="1px" width="40%" cellpadding="1px" cellspacing="0px" align="center">
			<tr align="center">
				<td>用户名:</td>
				<td><input type="text" name="user.username"/></td>
			</tr>
			<tr align="center">
				<td>密码:</td>
				<td><input type="password" name="user.password"/></td>
			</tr>
			<tr align="center">
				<td>性别:</td>
				<td><input type="text" name="user.sex"/></td>
			</tr>
			<tr align="center">
				<td>出生年月:</td>
				<td><input type="text" name="user.birthday"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
</body>
</html>