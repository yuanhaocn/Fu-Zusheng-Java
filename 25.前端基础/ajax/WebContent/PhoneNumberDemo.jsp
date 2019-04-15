<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	onload = function() {
		//获取输入框的值
		var number = document.getElementById("number");
		//设置输入框焦点时区时间，该事件只能在失去焦点的一瞬间触发一次，以后均不能触发，触发的前提是该组件已经获取到焦点
		number.onblur = function() {
			//ajax的使用
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.status == 200 && xhr.readyState == 4) {
					var info = xhr.responseText;
					var mylabel = document.getElementById("mylabel");
					//判断后天的值
					if (info) {
						mylabel.innerText = "改手机号可以注册！";
						mylabel.style.color = "green";
					} else {
						mylabel.innerText = "改手机号不可以注册！";
						mylabel.style.cssText = "color:red";
					}
				}
			}
			xhr.open("GET",
					"${pageContext.request.comtextPath}/phoneNumberServlet?number="
							+ number.value);
			xhr.send();
		}
	}
</script>
</head>
<body>
	number:
	<input type="tel" id="number" />
	<label id="mylabel"></label>
</body>
</html>