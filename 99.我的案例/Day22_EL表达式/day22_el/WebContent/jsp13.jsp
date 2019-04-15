<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.syc.el.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- MyEclipse中自带jstl.jar包,所以在MyEclipse中不需要引入第三方jar; -->
<!-- Eclipse中不自带jstl.jar包 -->
<!-- 在使用jstl标签之前,必须在jsp页面上面,引入taglib指令 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl基本用法</title>
</head>
<body>
	<!-- jstl标签库:1.核心标签库(c标签库);2.国际化标签库;3.sql标签库;
	     4.xml标签库;5.el标签库; -->

	<!-- c标签库中常用的标签:
		 set标签;
		 out标签;
		 if...;
		 forEach;
		 choose...when...otherwise;
		 forTokens..;
		 redirect;
		 url;
	 -->

	<b>1.set标签</b>
	<!-- jstl表达式存值 -->
	<!-- 1.set标签:用来保存数据,声明变量,默认保存到page域中 -->
	<c:set var="name" value="syc" scope="page"></c:set>

	<!-- el表达式取值 -->
	<br>姓名:${name}

	<hr>
	<b>2.out标签</b>

	<!-- 保存到page域 -->
	<%
		String msg = null;
		pageContext.setAttribute("msg", msg);
	%>

	<!-- out标签的作用:用来输出某个域中的信息. -->
	<!-- value:要输出的内容;default:设置默认值,当输出的内容为空的时候会生效;
		 escapeXml:相当于是转义字符,默认为true,不转义,default如果带了html标签,原文输出;
		 false:进行转义,default如果带了html标签,就会按照该标签的作用输出内容.
	 -->
	<br>
	<c:out value="${msg}" default="<h2>默认值<h2>" escapeXml="false"></c:out>

	<hr>
	<b>3.choose...when...otherwise</b>
	<!-- 以上3个标签经常配合使用,开发过程中非常常用! -->
	<!-- 以上3个标签配合达到的效果,类似于switch语句的效果. -->
	<c:set var="score" value="8"></c:set>
	<!-- 列举每一种情况: -->
	<!-- choose就相当于switch -->
	<!-- when相当于case -->
	<!-- otherwise相当于default -->
	<!-- test的值是一个条件表达式 -->
	<!-- 其他情况 -->
	<br>
	<c:choose>
		<c:when test="${score>=90&&score<=100}">
	   		优秀
	   </c:when>
		<c:when test="${score>=80&&score<90}">
	   		良好
	   </c:when>
		<c:when test="${score>=70&&score<80}">
	   		一般
	   </c:when>
		<c:when test="${score>=60&&score<70}">
	   		及格
	   </c:when>
		<c:otherwise>
			不及格
		</c:otherwise>
	</c:choose>

	<hr>
	<b>4.forEach标签</b>
	<%
		List<Student> students = new ArrayList<>();
		students.add(new Student("张三", 20, "男"));
		students.add(new Student("李四", 30, "女"));
		students.add(new Student("王八", 38, "男"));
		pageContext.setAttribute("students", students);
	%>

	<!-- begin:指定要遍历的循环的起始位置;end:指定要遍历循环的结束位置;
		 step:指定每次遍历的步长;通常情况下,这3个属性不需要配置. -->
	<!-- items:通常代表要遍历的集合,该属性往往要集合el表达式来用. -->
	<!-- var:给要遍历的集合起一个别名; -->
	<!-- varStatus:取出集合的每一行的行号 -->
	<c:forEach begin="0" end="2" step="1" items="${students}" 
		var="stu" varStatus="vs">
		<br>序号:${vs.count}--姓名:${stu.name}--年龄:${stu.age}--性别:${stu.sex}
	</c:forEach>

	<hr>
	遍历Map集合
	<%
		Map<String, Student> map = new HashMap<>();
		map.put("100", new Student("张三", 20, "男"));
		map.put("101", new Student("张四", 21, "女"));
		map.put("102", new Student("张五", 22, "女"));
		pageContext.setAttribute("map", map);
	%>
	<c:forEach items="${map}" var="entry" varStatus="vs">
		<br>序号:${vs.count}--学生编号:${entry.key}--姓名:${entry.value.name}--年龄:${entry.value.age}
	</c:forEach>

</body>
</html>