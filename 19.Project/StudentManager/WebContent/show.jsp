<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.qfedu.domain.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用内置对象获取session域对象的值 -->
	<%
		Student stu = (Student)session.getAttribute("student");
	%>
	
	
	<%
		if(stu.getNumber()==null){
			
		%>
		
		<h1 style="color: red">没有数据</h1>
		
		<% 	
			
			
		}else{
	
	%>
	
	<br>
	<table>
	<tbody>
		<tr>
			<td>number</td>
			<td><%=stu.getNumber()%></td>
		</tr>
		<tr>
			<td>name</td>
			<td><%=stu.getName()%></td>
		</tr>
		<tr>
			<td>sex</td>
			<td><%=stu.getAge()%></td>
		</tr>
	</tbody>
	</table>
	<%} %>
</body>
</html>