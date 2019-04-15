<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--list指令</title>
</head>
<body>
	
	<table border="1">
		<tr><td>行号</td><td>编号</td><td>姓名</td><td>年龄</td><td>身高</td></tr>
		<#list users as user>
			<#if user_index % 2 = 0>
				<tr bgColor = "blue">
			<#else>
				<tr bgColor = "yellow">
			</#if>		
				<td>${user_index+1}</td>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.height}</td>
			</tr>
		</#list>
	</table>
																	
</body>
</html>