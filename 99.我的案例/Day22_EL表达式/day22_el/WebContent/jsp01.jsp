<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String name="syc";
	   int age=20;
	   double weight=60.0;
	   pageContext.setAttribute("name", name);
	   pageContext.setAttribute("weight",weight);
	   pageContext.setAttribute("age", age,PageContext.SESSION_SCOPE);
	%>
	
	<!-- 传统的JSP取值方式 -->
	姓名:<%=pageContext.getAttribute("name") %><br>
	<%-- 年龄:<%=pageContext.getAttribute("age",PageContext.SESSION_SCOPE) %><br> --%>
	年龄:<%=pageContext.findAttribute("age") %><br>
	
	<!-- EL表达式的写法 -->
	<!-- EL的内部原理:jsp解析器一看到/$\{\},就会去获取里面的key,然后jsp引擎就会调用pageContext.findAttribute(key) -->
	姓名:${name}---->年龄:${age}--->体重:${weight}<br>
	<!-- EL内部也是分为4个作用域,与JSP一样 -->
	<!-- pageScope,requestScope,sessionScope,applicationScope -->
	姓名:${name}---->年龄:${sessionScope.age}--->体重:${weight}
</body>
</html>