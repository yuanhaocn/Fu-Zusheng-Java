<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax 02</title>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
	
	function checkName(){
		
		var name=document.getElementById("name").value;
		
		//发送请求,处理返回的响应结果.
		
		//1.获取XMLHttpRequest对象
		var xhr=getXMLHttpRequest();
		
		//4.处理响应结果
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var msg=xhr.responseText;
				//alert(msg);
				document.getElementById("msg").innerHTML=msg;
			}
		}
		
		//2.建立连接
		xhr.open("GET","${pageContext.request.contextPath}/secondServlet?name="+name,true);
		
		//3.发送请求
		xhr.send();
	}
	
</script>

</head>
<body>
	<input type="text" id="name"><span id="msg"></span><br>
	<input type="button" value="发送请求" onclick="checkName()">
	
</body>
</html>