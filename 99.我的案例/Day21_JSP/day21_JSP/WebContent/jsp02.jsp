<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp02</title>
</head>
<body>
	<!-- 定义一个变量 -->
	<%
		String name = "syc";
		out.write("name=" + name + "<br>");
	%>

	<!-- 引用另一个代码段中的变量. -->
	<%="Name=" + name + "<br>"%>

	<%
		int a = 3;
		int b = 4;
	%>

	<!--html与jsp代码嵌套  -->
	a+b=<%=a + b + "<br>"%>

	<%
		Random rd = new Random();
		int value = rd.nextInt(100);
	%>

	随机数=<%=value + "<br>"%>

	<!-- html与jsp混合 -->
	<!-- jsp和html可以很随意的进行嵌套,只要保证双方的语法正确. -->
	<%
		for (int i = 1; i <= 6; i++) {
	%>

	<!-- <h1>一级标题</h1> -->

	<%-- <h1>一级标题<%=i%></h1> --%>

	<h <%=i%>> <%=i%>级标题 </h<%=i%>>

	<%
		}
	%>

	<!-- jsp中方法的声明 -->
	<!-- 方法和变量的声明</%!%> -->
	<%!
		String msg = "被返回的信息";
	%>
	
	<!-- 注意:很少在jsp中定义方法.而且还要注意,jsp中尽量少写java代码! -->
	<%! public String getMsg() {

		return msg;
	}%>

	调用方法:<%=getMsg() %>
</body>
</html>