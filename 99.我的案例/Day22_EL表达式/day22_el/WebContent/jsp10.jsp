<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>取值</title>
</head>
<body>
	
	<!-- 注意:如果要在另外的一个jsp页面去取其他页面的值,在本页面也必须声明javaBean -->
	<jsp:useBean id="student" scope="session" class="com.syc.el.Student"></jsp:useBean>

	<!-- 取值的动作元素 -->
	<br>姓名:<jsp:getProperty property="name" name="student"/>
	<br>年龄:<jsp:getProperty property="age" name="student"/>
	<br>性别:<jsp:getProperty property="sex" name="student"/>
</body>
</html>