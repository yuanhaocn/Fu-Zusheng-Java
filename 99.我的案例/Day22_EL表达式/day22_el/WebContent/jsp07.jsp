<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收传递过来的参数</title>
</head>
<body>
	<h1>第7个jsp页面</h1>
	姓名:<%=request.getParameter("name") %>
	<!-- 注意:request.getAttribute(name)是获取不到值的. -->
	<%-- 密码:<%=request.getAttribute("pass") %> --%>
	 密码:<%=request.getParameter("pass") %>
	
</body>
</html>