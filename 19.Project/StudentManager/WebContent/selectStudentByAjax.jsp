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
		var number = document.getElementById("number").value;
		var mydiv = document.getElementById("mydiv");
		//设置按钮点击事件
		document.getElementById("select").onclick = function() {
			//使用ajx进行数据传递
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (chr.status == 200 && xhr.readyState == 4) {
					//返回的值是一个json字符串
					var jsonStr = xhr.responseText;
					//5.把字符创转为json对象
					var jsonObj = JSON.parse(jsonStr);
					//读取对象的值，设置到div里面去
					mydiv.innerHTML = "<label>name:" + jsonObj.name
							+ "</label><br>" + "<label>age:" + jsonObj.age
							+ "</label><br>" + "<label>number:"
							+ jsonObj.number + "</label><br>"
				}
			}
			xhr.open("GET", "${pageContext.request.contextPath}/selectStudentByAjaxServlet?number="+number);
			xhr.send();
		}
	}
</script>
</head>
<body>
	<input type="text" id="number" />
	<input type="button" value="查询" id="select" />
	<div id="mydiv"></div>
</body>
</html>