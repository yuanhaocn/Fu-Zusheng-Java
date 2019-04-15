<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//onload函数，还有设置按钮点击事件
	onload=function(){
		document.getElementById("mybtn").onclick=function(){
			//2.请求服务器XMLHttpRequest对象
		var xMLHttpRequest=new XMLHttpRequest();
		/*3.打开域服务器的连接通道
		       参数： 1)请求方式 get/post 是String类型  		可选
		       2)url 是String类型的，支持el表达式 		必选
		       3)async 是否异步提交，默认异步，设置为同步的话，ajax不能工作		 可选
		       4)username连接服务器的用户名		 可选
		       5)password连接服务器的密码 		可选
		*/
		xMLHttpRequest.open("get","${pageContext.request.contextPath}/ajaxServlet01","true");
		 //4.发送
		xMLHttpRequest.send();
		}
	}


</script>
</head>
<body>
<button id="mybtn">提交ajax到达服务器</button>
</body>
</html>