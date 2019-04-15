<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<script src="jquery-3.3.1.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			$("mybtn").click(function(){
				//获取输入框的值
				var value=$("#mytext").val();
				//开启ajax
				$.ajax({
					//设置提交方式，如果是低版本，使用type代替
					method:"get",
					url:"${pageContext.request.contextPath}/JqAjaxServlet01",
					//data属性是提交到后台的数,据
					Date:"value="+value,
					//success值得数status为200 readystate为4 的状态
					//参数是一个代表原生responseText属性的对象
					success:function(info){
						alert(info);
					},
					error:function(){
						alert("理解万岁");
					}
				});                  
			});
		});
		</script>
</head>
<body>
	<input type="text" id="mytext"/>
		<button id="nybtn">提交数据到后台</button>
</body>
</html>