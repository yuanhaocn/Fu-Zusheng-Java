<%@page import="com.syc.el.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp02</title>
</head>
<body>
	<% Student stu=new Student("三胖",30,"男");
	   pageContext.setAttribute("student", stu);
	%>
	
	<!-- jsp解析器一看到\$\{\}符号,就取里面的key---student,根据student这个key去取对应的值.
		Student stu=pageContext.findAttribute("student");
		stu.name=stu.getName();
		el表达式根据key来获取值的时候,内部是不需要进行类型转换的,类似于js的多类型转换无关性.
	 -->
	<br>姓名:${student.name}
	<br>年龄:${student.age }
	<!-- 实际一般不会这么写:stu.getXXX()没有stu.key的方式更简洁 -->
	<br>性别:${student.getSex() }
</body>
</html>