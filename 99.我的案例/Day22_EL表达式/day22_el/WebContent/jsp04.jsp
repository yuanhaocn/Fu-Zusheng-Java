<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式的运算符</title>
</head>
<body>
	el中进行算术运算
	<br>
	<b>算术运算符</b>
	<br>10+5=${10+5}
	<br>10x5=${10*5}

	<hr>
	<b>比较运算符</b>
	<br>10<5=${10<5}
	<br>10>5=${10>5}

	<hr>
	<b>逻辑运算符</b>
	<br>true&&false=${true&&false}
	<br>true||false=${true||false}
	<br>!true=${!true}

	<hr>
	<b>条件运算符</b>
	<%
		int age1 = 10;
		pageContext.setAttribute("age", age1);
	%>
	<br>${age>=18 ? "成年人" : "未成年人" }
	
	<hr>
	<b>判断字符串是否为空</b>
	<% String msg=null;
	   pageContext.setAttribute("msg", msg);
	 %>
	 <!-- 判断字符串非空,有2种情况: -->
	<br>msg==null?---${msg==null}
	<br>msg==""?---${msg==""}
	<!-- empty关键字,可以用来判断一个对象是否为空 -->
	<br>msg为空吗?---${empty msg}
</body>
</html>