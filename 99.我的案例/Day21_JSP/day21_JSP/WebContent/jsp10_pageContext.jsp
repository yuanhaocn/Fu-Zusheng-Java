<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext对象</title>
</head>
<body>
	
	out==pageContext.getOut()?-----<%= out.equals(pageContext.getOut()) +"<br>"%>
	session==pageContext.session()?-----<%= session.equals(pageContext.getSession()) +"<br>"%>
	request对象---<%= pageContext.getRequest()  +"<br>"%>
	response对象---<%= pageContext.getResponse() +"<br>" %>
	page对象---<%= pageContext.getPage()  +"<br>"%>
	exception对象---<%= pageContext.getException()  +"<br>"%>
	config对象---<%= pageContext.getServletConfig()  +"<br>"%>
	<!-- application:该对象只有一个 -->
	application对象---<%= pageContext.getServletContext()  +"<br>"%>
	
	<hr>
	Servlet名称:<%=config.getServletName()+"<br>" %>
	
	<!-- request.getContextPath(); -->
	jsp路径1:<%=request.getContextPath() +"<br>"%>
	jsp路径2:<%=pageContext.getServletContext().getContextPath()+"<br>" %>
	jsp路径3:<%=application.getContextPath()+"<br>" %>
	
	
</body>
</html>