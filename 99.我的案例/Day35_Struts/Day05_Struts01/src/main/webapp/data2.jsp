<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>data2</title>
</head>
<body>
	<s:property value="[0].name"/>---<s:property value="[0].nickname"/>
	<br>
	<s:property value="[1].name"/>---<s:property value="[1].nickname"/>
	<br>
	<s:property value="[2]"/>
	<br>
	<!-- 根据key取值 -->
	<s:property value="person.name"/>---<s:property value="person.nickname"/>
</body>
</html>