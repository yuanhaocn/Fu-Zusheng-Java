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
<title>取出集合中的数据</title>
</head>
<body>

	<%
		List<Student> students = new ArrayList<>();
		students.add(new Student("张三", 20, "男"));
		students.add(new Student("李四", 30, "女"));
		students.add(new Student("王八", 38, "男"));
		pageContext.setAttribute("students", students);
	%>

	遍历List集合
	<!-- 遍历List集合 -->
	<!-- 取出List集合每个对象的数据 -->
	<!-- 1.List<Student> students=pageContext.findAttibute("students");
		 2.students[0]相当于students.get(0),此时得到Student对象;
		 3.利用Student对象.name得到姓名.
	 -->
	<br>姓名:${students[0].name}---年龄:${students[0].age}---性别:${students[0].sex}
	<br>姓名:${students[1].name}---年龄:${students[1].age}---性别:${students[1].sex}
	<br>姓名:${students[2].name}---年龄:${students[2].age}---性别:${students[2].sex}

	<hr>
	遍历Map集合
	<%
		Map<String,Student> map = new HashMap<>();
		map.put("100", new Student("张三", 20, "男"));
		map.put("101", new Student("张四", 21, "女"));
		map.put("102", new Student("张五", 22, "女"));
		pageContext.setAttribute("map", map);
	%>
	<!-- Map集合的内部实现:
		1.根据key找到Map集合:
		  Map<String,Student> map=pageContext.findAttibute("map");
	    2.在map中,根据key获取对象:
	      map["100"]----map.get("100")----Student;
	    3.在对象中,根据key取具体的值:
	      student.name=student.getName();  
	 -->
	<br>姓名:${map["100"].name}---年龄:${map["100"].age}---性别:${map["100"].sex}
	<br>姓名:${map["101"].name}---年龄:${map["101"].age}---性别:${map["101"].sex}
	<br>姓名:${map["102"].name}---年龄:${map["102"].age}---性别:${map["102"].sex}
	
</body>
</html>