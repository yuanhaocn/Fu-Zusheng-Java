<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<!-- http://localhost:8080/day23_updownload/file?method=upload -->
	<form action="${pageContext.request.contextPath}/file?method=upload" method="post" enctype="multipart/form-data">
		姓名:<input type="text" name="name"><br>
		文件:<input type="file" name="fileName"><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>