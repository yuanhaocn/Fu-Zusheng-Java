<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 03</title>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
	
	function postAjax() {
		
		var name=document.getElementById("name").value;
		var pass=document.getElementById("pass").value;
		
		//1.创建对象
		var xhr = getXMLHttpRequest();
		//2.建立连接
		xhr.open("post", "${pageContext.request.contextPath}/thirdServlet",
				true);
		//3.设置请求头
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		//4.发送要传递的数据
		xhr.send("name=" + name + "&pass=" + pass);

		//5.处理响应结果
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var msg = xhr.responseText;
				alert(msg);
			}
		}
	}
</script>

</head>
<body>
	用户名:<input type="text" id="name"><br>
	密码:<input type="password" id="pass"><br>
	<input type="button" value="post请求" onclick="postAjax()">
</body>
</html>