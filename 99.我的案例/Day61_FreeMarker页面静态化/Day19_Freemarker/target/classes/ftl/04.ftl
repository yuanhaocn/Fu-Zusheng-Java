<#--注释部分-->
<#--插值模板的语法-->
<!DOCTYPE html>
<html>
	<head>
		<title>传入对象类型</title>
	</head>
	<body>
		<div>
			<ul>
				<#list users as user>
					<li>行号:${user_index+1}-用户编号:${user.id}-用户姓名:${user.name}-用户年龄:${user.age}-用户性别:${user.sex}</li>
				</#list>
			</ul>
		</div>
	</body>
</html>

