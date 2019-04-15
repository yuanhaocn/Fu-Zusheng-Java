<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>data5</title>
</head>
<body>
	<table align="center" width="50%" height="200px" border="1px"
		style="border-color: red" cellpadding="1px" cellspacing="0px">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>昵称</td>
		</tr>
		<!-- value:等同于jstl中forEach标签的items属性;var....;status等同于...vsStatus属性 -->
		<s:iterator value="persons" var="person" status="st">
			<tr align="center">
				<td><s:property value="#st.count"/></td>
				<td><s:property value="#person.name"/></td>
				<td><s:property value="#person.nickname"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	
	<!-- iterator中,可以省略var属性 -->
	<table align="center" width="50%" height="200px" border="1px"
		style="border-color: red" cellpadding="1px" cellspacing="0px">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>昵称</td>
		</tr>
		<!-- value:等同于jstl中forEach标签的items属性;var....;status等同于...vsStatus属性 -->
		<s:iterator value="persons" status="st">
			<tr align="center">
				<td><s:property value="#st.count"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="nickname"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	<!-- iterator中,可以添加过滤条件 -->
	<table align="center" width="50%" height="200px" border="1px"
		style="border-color: red" cellpadding="1px" cellspacing="0px">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>昵称</td>
			<td>年龄</td>
		</tr>
		<!-- value:等同于jstl中forEach标签的items属性;var....;status等同于...vsStatus属性 -->
		<s:iterator value="persons.{?#this.age<20}" status="st">
			<tr align="center">
				<td><s:property value="#st.count"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="nickname"/></td>
				<td><s:property value="age"/></td>
			</tr>
		</s:iterator>
	</table>
	
	<hr>
	<!-- iterator中,可以添加过滤条件 -->
	<table align="center" width="50%" height="200px" border="1px"
		style="border-color: red" cellpadding="1px" cellspacing="0px">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
		</tr>
		<!-- value:等同于jstl中forEach标签的items属性;var....;status等同于...vsStatus属性 -->
		<!-- persons.{name}被称为ognl投影 -->
		<s:iterator value="persons.{name}" status="st">
			<tr align="center">
				<td><s:property value="#st.count"/></td>
				<td><s:property/></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>