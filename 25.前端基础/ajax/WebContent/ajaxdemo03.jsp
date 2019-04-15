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
			//1.获取输入框的值
			var value = document.getElementById("username").value;
			var xMLHttpRequest = new XMLHttpRequest;
			xMLHttpRequest.onreadystatechange = function() {
				if (xMLHttpRequest.status == 200
						&& xMLHttpRequest.readyState == 4) {
					var info = xMLHttpRequest.responseText;
					alert(info);
				}
			}
			//2.准备发送，开启通道的时候需要把数据绑定到URL上作为发送数据
			//绑定过程中需要遵守get的URL规则，
			xMLHttpRequest.open("GET",
					"${pageContext.request.contextPath}/ajaxServlet03?value=" + value);
			xMLHttpRequest.send();
		}
	}
</script>
</head>
<body>
	username:
	<input type="text" id="username" />
	<button id="mybtn">提交数据到达后台</button>
</body>
</html>