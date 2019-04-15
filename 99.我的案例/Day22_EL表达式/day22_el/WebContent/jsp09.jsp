<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>useBean</title>
</head>
<body>
	<!-- userBean动作元素必须有id,且应该唯一. -->
	<!-- id:是该bean的编号;scope:指明该bean的作用域;class:指明该bean的完整路径 -->
	<jsp:useBean id="student" scope="session" class="com.syc.el.Student"></jsp:useBean>
	
	<!-- 赋值和取值的动作元素 -->
	<!-- 赋值：property:指明了bean中的某个属性;name:指明了要给哪个bean赋值;value:给某个属性赋的值 -->
	<jsp:setProperty property="name" name="student" value="张三"/>
	<jsp:setProperty property="age" name="student" value="18"/>
	<jsp:setProperty property="sex" name="student" value="女"/>
	
	<!-- 取值的动作元素 -->
	<br>姓名:<jsp:getProperty property="name" name="student"/>
	<br>年龄:<jsp:getProperty property="age" name="student"/>
	<br>性别:<jsp:getProperty property="sex" name="student"/>
</body>
</html>