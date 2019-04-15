<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/register" method="post">
		用户名:<input type="text" name="username">${form.infos.username}<br>
		密码:<input type="password" name="password">${form.infos.password}<br>
		确认密码:<input type="password" name="confirmPwd">${form.infos.confirmPwd}<br>
		邮箱:<input type="text" name="email">${form.infos.email}<br>
		出生日期:<input type="text" name="birthday">${form.infos.birthday}<br>
		<input type="submit" value="注册">
	</form>
</body>
</html>