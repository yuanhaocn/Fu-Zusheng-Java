<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ognl里的property</title>
</head>
<body>
	<!-- "key":表示根据这个"key"一个域一个域的去找对应的value -->
	<s:property value="key"/>
	<!-- "key":表示直接去大map中去找对应的value -->
	<s:property value="#key"/>
	
	<!-- "'msg'",在双引号中嵌套单引号,表示原文输出 -->
	<s:property value="'Hello-World'"/>
	
	<!-- ognl表达式,可以直接调用一个对象的实例方法 -->
	<s:property value="'Hello-World'.length()"/>
	<br>
	<s:property value="'Hello-World'.toUpperCase()"/>
	
	<!-- ognl表达式,可以调用对象的属性 -->
	<br>
	<s:property value="@java.lang.Integer@MAX_VALUE"/>
	<br>
	<s:property value="@java.lang.Integer@MIN_VALUE"/>
	
	<br>
	<!-- ognl表达式,也可以调用静态方法,默认情况下,不能直接调用类的静态方法. -->
	<s:property value="@java.lang.Math@random()"/>
	
	<br>
	<!-- 调用自定义的静态方法 -->
	<s:property value="@com.syc.struts.StaticMethodDemo@printMsg()"/>

</body>
</html>