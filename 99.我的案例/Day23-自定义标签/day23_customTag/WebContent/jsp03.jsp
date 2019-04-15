<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.syc.customlabel.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://com.syc.customlabel" prefix="custom"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		List<Student> students = new ArrayList<>();
		students.add(new Student("张三", 20, "男"));
		students.add(new Student("李四", 30, "女"));
		students.add(new Student("王八", 38, "男"));
		pageContext.setAttribute("students", students);
	%>
	<custom:forEach items="${students}" var="student">
		<br>姓名:${student.name}--年龄:${student.age}
	</custom:forEach>

	<hr>
	<%
		Map<String, Student> map = new HashMap<>();
		map.put("100", new Student("张三", 20, "男"));
		map.put("101",new Student("李四", 30, "女"));
		map.put("102",new Student("王八", 38, "男"));
		pageContext.setAttribute("map", map);
	%>
	<%-- ${map}---Map map=pageContext.findAttribute(map); --%>
	<custom:forEach items="${map}" var="entry">
		<br>编号:${entry.key}--姓名:${entry.value.name}--年龄:${entry.value.age}
	</custom:forEach>
	
</body>
</html>