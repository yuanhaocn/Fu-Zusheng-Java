<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
	//Locale locale=Locale.getDefault();
	Locale locale=Locale.US;
	ResourceBundle bundle=ResourceBundle.getBundle("com.syc.struts.resource.msg",locale);
%>
<title><%=bundle.getString("title") %></title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/register" method="post">
		<%=bundle.getString("username") %>:<input type="text" name="username"><br/>
		<%=bundle.getString("password") %>:<input type="password" name="password"><br/>
		<input type="submit" value='<%=bundle.getString("login") %>'>
	</form>
</body>
</html>