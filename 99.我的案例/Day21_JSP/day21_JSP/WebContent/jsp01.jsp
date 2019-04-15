<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp01-初识</title>
</head>
<body>
	<h1>JSP的输出方式</h1>
	<!-- JSP中所有的Java代码必须置于</%%> -->
	<!-- JSP的注释方式 -->
	<%-- <%="JSP输出方式一"; %> --%>
	<!-- 方式一:注意,=的输出方式中,语句最后不要加; -->
	<%= "JSP输出方式一" %>
	
	<hr>
	
	<!-- 输出方式二,此时必须在语句后面添加; -->
	<% out.write("JSP输出方式二"); %>

	<hr>	
	
	<!-- 输出方式三,利用response.getWriter()来输出 -->
	<% response.getWriter().write("JSP输出方式三");
	%>
	
	<!-- 输出当前时间 -->
	<% Date date=new Date();
	   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
	   String time=format.format(date);
	   out.write("当前时间="+time);
	   response.getWriter().write("当前时间2="+time);
	%>

	<!-- 引用另一段代码块中的变量 -->
	<%=time %>	
</body>
</html>