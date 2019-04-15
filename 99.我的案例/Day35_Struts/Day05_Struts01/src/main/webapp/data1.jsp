<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>data1</title>
</head>
<body>
	<!-- 取大"map"中的信息,#key表示直接去大"map"中取值 -->
	姓名:<s:property value="#name"/>
	
	<hr>
	request:<s:property value="requestData"/>
	<!-- #request:取出大map中的小map(request域),然后在小map中根据key(requestData)再取值. -->
	request:<s:property value="#request.requestData"/>
	
	<hr>
	<!-- s:property,对于session里的信息,用以往的方式直接根据key取值是取不出来的. -->
	<%-- session:<s:property value="sessionData"/> --%>
	<!-- s:property方式中,必须先取出小map,然后在小map中再根据key取值. -->
	session:<s:property value="#session.sessionData"/>
	
	<hr>
	<!-- 先取小map,然后在小map中根据key取值 -->
	application:<s:property value="#application.applicationData"/>
</body>
</html>