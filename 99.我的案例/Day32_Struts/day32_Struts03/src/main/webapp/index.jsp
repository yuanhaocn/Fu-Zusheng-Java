<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h1>登陆成功</h1>
	
	<hr/>
	<h3>取值----findAttribute(key)</h3>
	${requestName}
	
	<hr/>
	<h3>从request域取值</h3>
	${requestScope.requestName}
	
	<hr/>
	<h3>从session域取值</h3>
	${sessionScope.sessionName}
	
	<hr/>
	<h3>从application域取值</h3>
	${applicationScope.applicationName}
</body>
</html>