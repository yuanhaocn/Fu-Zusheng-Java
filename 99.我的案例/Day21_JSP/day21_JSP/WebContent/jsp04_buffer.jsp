<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="1kb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP页面的缓冲区</title>
</head>
<body>
	<!-- jsp默认情况下,是自带缓冲区的.一般情况下,使用缓冲区效率更高一些. -->
	<!-- jsp缓冲区的内容 要输出出来,需要满足4种情况之一才可以:-->
	<!-- 1.缓冲区满了,页会输出缓冲区里的内容; -->
	<!-- 2.jsp页面执行完了; -->
	<!-- 3.手动刷新缓冲区;out.flush(); -->
	<!-- 4.关闭缓冲区.buffer=0kb|none -->
	<% out.write("123"+"<br>");
	  /*  out.flush(); */
	  /* JspWriter out; */
	%>
	
	<% for(int i=0;i<1024;i++){
		
		out.write("Hello,缓冲区"+i);
	} %>
	
	<% response.getWriter().write("456"+"<br>");
	   /* PrintWriter writer=response.getWriter(); */
	%>
</body>
</html>