<#--注释部分-->
<#--插值模板的语法-->
<!DOCTYPE html>
<html>
	<head>
		<title>传入对象类型</title>
	</head>
	<body>
		<table>
			<tr>
				<td>行号</td>
				<td>用户编号</td>
				<td>用户姓名</td>
				<td>用户年龄</td>
				<td>用户性别</td>
			</tr>
			<#list users as user>
				<#if user_index % 2 = 0>
					<tr bgColor="#00f">
				<#else>
					<tr bgColor="#ff0">
				</#if>
						<td>${user_index+1}</td>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.age}</td>
						<td>${user.sex}</td>
					</tr>
			</#list>
		</table>
	</body>
</html>

