<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		提交方式必须是post提交，get不行
		enctype把表单提交方式从变量提交改为io的方式
	 -->
	<form action="${pageContext.request.contextPath}/fileUploadSuperServlet" method="post" enctype="multipart/form-data">
		username:<input type="text" name="username" /> <br>
		<input type="file" name="file"/><br>
		<input type="submit" value="上传"/>
	</form>
</body>
</html>




