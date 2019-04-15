<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp的4个作用域</title>
</head>
<body>
	<!-- jsp的4个作用域:1.page域;2.request域;3.session域;4.application域 -->
	<!-- 默认是page域 ,它的作用范围只能是在当前页面之内.-->
	<%pageContext.setAttribute("msg1", "我是Page域里的信息..."); %>
	
	<!-- request域 -->
	<% pageContext.setAttribute("msg2", "我是Request域中的信息...", PageContext.REQUEST_SCOPE); %>
	
	<!-- 从page域中取值 -->
	Page域-----><%=pageContext.getAttribute("msg1")+"<br>" %>
	
	<!-- 从request域取值 -->
	Request域-----><%=pageContext.getAttribute("msg2",PageContext.REQUEST_SCOPE)+"<br>" %>
	
	<!-- 注意:利用request域实现跨页面存取值,必须进行请求转发的跳转 -->
	<%-- <% request.getRequestDispatcher("/jsp12.jsp").forward(request, response);%> --%>
	<%-- <% response.sendRedirect(request.getContextPath()+"/jsp12.jsp");%> --%>
	
	<!-- session域 -->
	<% pageContext.setAttribute("msg3", "我是Session域中的信息...", PageContext.SESSION_SCOPE); %>
	
	<!-- application域 -->
	<% pageContext.setAttribute("msg4", "我是Application域中的信息...", PageContext.APPLICATION_SCOPE); %>

</body>
</html>