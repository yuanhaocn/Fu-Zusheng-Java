<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp动作元素</title>
</head>
<body>
	<!-- jsp的复杂写法. -->
	<%-- <% 
		request.setAttribute(name,value);
	    request.getRequestDispatcher("/jsp07.jsp").forward(request, response); %> --%>
	
	<!-- 简化写法 -->
	<%-- <jsp:forward page="/jsp07.jsp"></jsp:forward> --%>
	
	<!-- 转发的第3种写法 -->
	<!-- forword携带的参数 -->
	<!-- 注意:不能在jsp元素中嵌套html代码. -->
	<jsp:forward page="/jsp07.jsp">
		<jsp:param value="syc" name="name"/>
		<jsp:param value="123" name="pass"/>
	</jsp:forward>
</body>
</html>