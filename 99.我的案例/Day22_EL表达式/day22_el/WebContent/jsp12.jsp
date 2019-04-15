<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.syc.el.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业</title>
</head>
<body>
	<% String[] names=new String[]{"张三","李四","王五"};
	   pageContext.setAttribute("names", names);
	%>
	
	<b>遍历数组</b>
	<!-- 遍历数组 -->
	<br>姓名:${names[0]}
	<br>姓名:${names[1]}
	<br>姓名:${names[2]}
	
	<hr>
	<!-- List集合 -->
	<%
		List<Student> students = new ArrayList<>();
		students.add(new Student("张三", 20, "男"));
		students.add(new Student("李四", 30, "女"));
		students.add(new Student("王八", 38, "男"));
		pageContext.setAttribute("students", students);
	%>
	
	<b>遍历List集合</b>
	<% List<Student> list=(ArrayList<Student>)pageContext.getAttribute("students");
	   for(int i=0;i<list.size();i++){
	   pageContext.setAttribute("index", i);	   
	%>
	
	<%-- 内嵌el表达式 --%>
	<br>${index}--姓名:${students[index].name}--年龄:${students[index].age}--性别:${students[index].sex}
	
	<%} %>
	
	<hr>
	<!-- Map集合 -->
	<%
		Map<String,Student> map = new HashMap<>();
		map.put("100", new Student("张三", 20, "男"));
		map.put("101", new Student("张四", 21, "女"));
		map.put("102", new Student("张五", 22, "女"));
		pageContext.setAttribute("map", map);
	%>
	<b>遍历Map集合</b>
	<% Map<String,Student> maps=(HashMap<String,Student>)pageContext.getAttribute("map");
	   for(Map.Entry<String,Student> entry:maps.entrySet()){
		String key=(String)entry.getKey();   
	   	pageContext.setAttribute("key", key);
	%>
	
	<br>学生编号:${key}--姓名:${map[key].name}--年龄:${map[key].age}--性别:${map[key].sex}
	
	<%} %>
	
</body>
</html>