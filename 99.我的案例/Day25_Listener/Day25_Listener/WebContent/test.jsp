<%@page import="com.syc.listener.bind.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试的jsp</title>
</head>
<body>
	<% 
		//属性的添加
		request.setAttribute("name", "syc");
	
		//属性的替换
		request.setAttribute("name", "new-syc");
		
		//属性的移除
		request.removeAttribute("name");
	%>
	
	<%
		//session属性的添加
		session.setAttribute("age", 20);
		
		//属性的替换
		session.setAttribute("age", 30);
		
		//属性的销毁
		session.removeAttribute("age");
		//属性的销毁
		//session.invalidate();
	%>
	
	<%
	
		//添加属性
		application.setAttribute("weight", "10");
	
		//替换
		application.setAttribute("weight", "20");
		
		//移除
		application.removeAttribute("weight");
	%>
	
	<%
		User user=new User();	
		user.setName("syc");
		
		//session绑定了一个对象
		session.setAttribute("user", user);
		
		//解绑对象
		//session.removeAttribute("user");
		session.invalidate();
	%>
</body>
</html>