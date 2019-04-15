<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>关闭el表达式功能</title>
</head>
<body>
	<% String name="syc";
	   pageContext.setAttribute("name", name);
	%>
	
	<!-- el表达式一般情况下,都不会关闭.el表达式是jsp2.0以后才出现的,所以有些很古老的浏览可能不支持el功能.所以此时jsp如果包含el表达式,可能是造成错误. -->
	<!-- 注意:当关闭了el表达式功能之后,\$\{\}就会变成普通的字符串来输出了. -->
	姓名:\${name}
</body>
</html>