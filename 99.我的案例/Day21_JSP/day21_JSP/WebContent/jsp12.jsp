<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4个作用域</title>
</head>
<body>

	<!-- 从page域中取值 -->
	Page域-----><%=pageContext.getAttribute("msg")+"<br>"%>
	
	<!-- 从request域取值 -->
	Request域-----><%=pageContext.getAttribute("msg2",PageContext.REQUEST_SCOPE) +"<br>"%>
	
	<!-- 从session域取值 -->
	Session域-----><%=pageContext.getAttribute("msg3",PageContext.SESSION_SCOPE) +"<br>"%>
	
	<!-- 从application域取值 -->
	Application域-----><%=pageContext.getAttribute("msg4",PageContext.APPLICATION_SCOPE) +"<br>"%>
</body>
</html>