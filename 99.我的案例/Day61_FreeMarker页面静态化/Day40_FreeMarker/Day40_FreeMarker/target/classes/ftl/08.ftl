<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--空值处理</title>
</head>
<body>
	
	<#-- object??,表示判断该对象是否不等于空! -->
	<#if user??>
		<table border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>身高</td>
			<td>日期</td>
		</tr>
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.age}</td>
			<td>${user.height}</td>
			<#-- string("yyyy/MM/dd hh:mm:ss zzzz") -->
			<td>${user.birthday?datetime}</td>
		</tr>
	</table>
	<#else>
		<h1>数据为空!</h1>
	</#if>
	
																	
</body>
</html>