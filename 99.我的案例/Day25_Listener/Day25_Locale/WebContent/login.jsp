<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	ResourceBundle bundle = ResourceBundle.getBundle("com.syc.i18n.login", Locale.getDefault());
%>
<title><%= bundle.getString("title") %></title>
</head>
<body>
	<form action="#" method="post">
		<%= bundle.getString("name") %>:<input type="text" name="name"><br /> 
		<%= bundle.getString("pass") %>:<input type="password" name="pass"><br /> 
		<input type="submit" value='<%=bundle.getString("submit") %>'>
	</form>
</body>
</html>