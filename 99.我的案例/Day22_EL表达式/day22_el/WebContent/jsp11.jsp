<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>12个内置(隐含)对象</title>
</head>
<body>
	<!-- pageContext对象可以在el表达式中直接获取 -->
	<br>pageContext:${pageContext}
	
	<!-- 以下的8个对象,不能在el表达式中直接获取,必须通过pageContext对象来获取. -->
	<br>request:${pageContext.request}
	<br>response:${pageContext.response}
	<br>out:${pageContext.out}
	<br>session:${pageContext.session}
	<br>page:${pageContext.page}
	<br>application:${pageContext.servletContext}
	<br>exception:${pageContext.exception}
	<br>config:${pageContext.servletConfig}
	
	<!-- 另外的4个对象,值得是4个作用域. -->
	<br>page域:${pageScope }
	<br>request域:${requestScope }
	<br>session域:${sessionScope }
	<br>application域:${applicationScope }
</body>
</html>