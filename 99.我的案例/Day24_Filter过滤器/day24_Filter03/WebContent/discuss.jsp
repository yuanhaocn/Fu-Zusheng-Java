<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/ckeditor/simples/simple.css">
<title>论坛编辑区</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/web/discuss" method="post">
		<textarea class="ckeditor" name="content"></textarea>
		<br> <input type="submit" value="提交">
	</form>

	<hr>
	${requestScope.content}
</body>
</html>