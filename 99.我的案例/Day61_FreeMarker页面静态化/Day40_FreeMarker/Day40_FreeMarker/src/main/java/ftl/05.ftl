<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FreeMarker模板--list指令</title>
</head>
<body>
	
	<ul>
		<#list users as user>
			<li>行号:${user_index+1}-ID:${user.id}-姓名:${user.name}-年龄:${user.age}-身高:${user.height}</li>
		</#list>
	</ul>
																	
</body>
</html>