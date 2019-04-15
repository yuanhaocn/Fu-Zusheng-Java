<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	onload = function() {
		document.getElementById("mybtn").onclick = function() {
			//1.获取xmlhttprequest对象
			var xMLHttpRequest = new XMLHttpRequest();
			//2.做好接受和发送的准备
			xMLHttpRequest.onreadystatechange = function() {
				//保证请求和响应都没问题的前提下才可以接受数据
				if (xMLHttpRequest.status = 200 && xMLHttpRequest.readyState == 4) {
					//获取后台响应的数据
					var info = xMLHttpRequest.responseText;
					alert(info);
				}
			}
			//3.打开发送的通道
			xMLHttpRequest.open("GET",
					"${pageContext.request.contextPath}/ajaxServlet02");
			//4.发送请求到达服务器
			xMLHttpRequest.send();
		}
	}
</script>
</head>
<body>
	<button id="mybtn">点击发起ajax访问服务器</button>
</body>
</html>